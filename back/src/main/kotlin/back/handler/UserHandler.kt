package back.handler

import back.model.User
import back.repository.UserRepository
import back.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserHandler(private val repository: UserRepository, val service: UserService) {

    @PostMapping("/api/users/login")
    fun authenticate( @RequestBody email: String, password: String): User {
        try {
            service.authLogin(email, password)
            val user = repository.findByEmail(email)

            user!!.token = service.getNewToken()
            return user
        } catch (e: Error) {
            // error handler 따로 구현
            throw e
        }
    }

    @PostMapping("/api/users")
    fun register( @RequestBody userName: String, email: String, password: String): User {
        try {
            service.authRegister(email, password)
            val user = User(email = email,
                username = userName,
                password = password)

            user.token = service.getNewToken()
            return repository.save(user)
        } catch (e: Error) {
            // error handler 따로 구현
            throw e
        }
    }

    @GetMapping("/api/user")
    fun getCurrentUser(): User = service.currentUser()


    @PutMapping("/api/user")
    fun updateUser( @RequestBody email: String, bio: String, image: String): User {
        // bio, image update ??
        TODO()
    }

}
