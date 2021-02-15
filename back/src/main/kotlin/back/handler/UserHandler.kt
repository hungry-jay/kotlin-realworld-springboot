package back.handler

import back.model.Profile
import back.model.User
import back.repository.UserRepository
import back.service.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

class UserHandler(private val repository: UserRepository, val service: UserService) {

    @PostMapping("/api/users/login")
    fun authenticate( @RequestBody email: String, password: String): User {
        // 1. email & password auth, 해당 user 찾아오기
        // 2. token 부여
        TODO()
    }

    @PostMapping("/api/users")
    fun register( @RequestBody userName: String, email: String, password: String): User {
        // 1. auth
        // 2. token 부여

        val user = User(email = email,
            username = userName,
            password = password)

        return repository.save(user)
    }

    @GetMapping("/api/user")
    fun getCurrentUser(): User = service.currentUser()


    @PutMapping("/api/user")
    fun updateUser( @RequestBody email: String, bio: String, image: String): User {
        // bio, image update ??
        TODO()
    }

}
