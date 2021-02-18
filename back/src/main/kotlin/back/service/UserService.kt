package back.service

import back.model.User
import back.repository.UserRepository
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.stereotype.Service

@Service
class UserService (val repository: UserRepository){

    val currentUser = ThreadLocal<User>() // get set remove

    fun login(email: String, password: String): User {
        repository.findByEmail(email)?.let {
            if (it.password !== password)
                throw Error("401 login error; password failure")
            it.token = getNewToken()
            return repository.save(it)
        }
        throw Error("401 login error; user not found")
    }

    fun register(email: String, username: String, password: String): User {
        if(repository.existsByEmail(email))
            throw Error("401 register error; duplicated email")
        if(repository.existsByUsername(username))
            throw Error("401 register error; duplicated username")
        val user = User(email = email,
            username = username,
            password = password)
        user.token = getNewToken()
        return repository.save(user)
    }

    fun currentUser(): User = currentUser.get()

    fun getNewToken(): String = JWT.create()
        .withIssuer("auth0")
        .sign(Algorithm.HMAC256(currentUser.get().password))

    fun update(email: String?,
               username: String?,
               password: String?,
               bio: String?,
               image: String?): User { // DTO를 통해 유연하게 in out
        val currentUser = currentUser()

        if(email != null && currentUser.email != email && repository.existsByEmail(email))
                throw Error("401 update error; duplicated email")

        if(username != null && currentUser.username != username && repository.existsByUsername(username))
            throw Error("401 update error; duplicated username")

        val updatedUser = currentUser.copy(email = email ?: currentUser.email,
            username = username ?: currentUser.username,
            password = password ?: currentUser.password,
            bio = bio ?: currentUser.bio,
            image = image ?: currentUser.image)

        if(password != null)
            updatedUser.token = getNewToken()

        return repository.save(updatedUser)
    }

}