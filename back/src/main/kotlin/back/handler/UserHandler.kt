package back.handler

import back.model.DTO.Login
import back.model.DTO.Register
import back.model.DTO.UpdateUser
import back.model.User
import back.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserHandler(private val service: UserService) {

    @PostMapping("/api/users/login")
    fun authenticate(@RequestBody login: Login): Map<String, User> {
        return try {
            view(service.login(login))
        } catch (e: Error) {
            // error handler 따로 구현
            throw e
        }
    }

    @PostMapping("/api/users")
    fun register(@RequestBody register: Register): Map<String, User> {
        return try {
            view(service.register(register))
        } catch (e: Error) {
            // error handler 따로 구현
            throw e
        }
    }

    @GetMapping("/api/user")
    fun getCurrentUser(): User = service.currentUser()

    @PutMapping("/api/user")
    fun updateUser(@RequestBody user: UpdateUser): Map<String, User> {
        return try {
            view(service.update(user))
        } catch (e: Error) {
            // error handler 따로 구현
            throw e
        }
    }

    fun view(user: User) = mapOf("user" to user)
}
