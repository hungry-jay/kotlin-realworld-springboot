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
        return try {
            service.login(email, password)
        } catch (e: Error) {
            // error handler 따로 구현
            throw e
        }
    }

    @PostMapping("/api/users")
    fun register( @RequestBody username: String, email: String, password: String): User {
        return try {
            service.register(email, username, password)
        } catch (e: Error) {
            // error handler 따로 구현
            throw e
        }
    }

    @GetMapping("/api/user")
    fun getCurrentUser(): User = service.currentUser()


    @PutMapping("/api/user")
    fun updateUser( @RequestBody email: String,
                    username: String,
                    password: String,
                    bio: String,
                    image: String): User {
        return try {
            service.update(email, username, password, bio, image)
        } catch (e: Error) {
            // error handler 따로 구현
            throw e
        }
    }

}
