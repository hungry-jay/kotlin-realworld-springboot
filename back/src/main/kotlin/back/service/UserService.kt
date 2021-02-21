package back.service

import back.model.User
import back.model.dto.Login
import back.model.dto.Register
import back.model.dto.UpdateUser
import back.repository.UserRepository
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.stereotype.Service

@Service
class UserService(val repository: UserRepository) {

    private val currentUser = ThreadLocal<User>() // get set remove

    fun login(login: Login): User {
        repository.findByEmail(login.email)?.let {
            if (it.password !== login.password)
                throw Error("401 login error; password failure")
            it.token = getNewToken()
            return repository.save(it)
        }
        throw Error("401 login error; user not found")
    }

    fun register(register: Register): User {
        if (repository.existsByEmail(register.email))
            throw Error("401 register error; duplicated email")
        if (repository.existsByUsername(register.username))
            throw Error("401 register error; duplicated username")
        val user = User(
            email = register.email,
            username = register.username,
            password = register.password
        )
        user.token = getNewToken()
        return repository.save(user)
    }

    fun currentUser(): User = currentUser.get()

    fun getNewToken(): String = JWT.create()
        .withIssuer("auth0")
        .sign(Algorithm.HMAC256(currentUser.get().password))

    fun update(user: UpdateUser): User { // DTO를 통해 유연하게 in out
        val currentUser = currentUser()

        if (user.email != null && currentUser.email != user.email &&
            repository.existsByEmail(user.email)
        )
            throw Error("401 update error; duplicated email")

        if (user.username != null && currentUser.username != user.username &&
            repository.existsByUsername(user.username)
        )
            throw Error("401 update error; duplicated username")

        val updatedUser = currentUser.copy(
            email = user.email ?: currentUser.email,
            username = user.username ?: currentUser.username,
            password = user.password ?: currentUser.password,
            bio = user.bio ?: currentUser.bio,
            image = user.image ?: currentUser.image
        )

        if (user.password != null) // token 수정되어야 하는 경우
            updatedUser.token = getNewToken()

        return repository.save(updatedUser)
    }

    fun findByUsername(username: String): User? = repository.findByUsername(username)

    fun save(user: User): User = repository.save(user)
}
