package back.handler

import back.model.Profile
import back.model.User
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping

class UserHandler {

    @PostMapping("/api/users/login")
    fun authenticate(): User {
        TODO()
    }

    @PostMapping("/api/users")
    fun register(): User {
        TODO()
    }

    @GetMapping("/api/user")
    fun getCurrentUser(): User {
        TODO()
    }

    @PutMapping("api/user")
    fun updateUser(): User {
        TODO()
    }

    @GetMapping("/api/profiles/{username}")
    fun getProfile(): Profile {
        TODO()
    }

    @PostMapping("/api/profiles/{username}/follow")
    fun followUser(): Profile {
        TODO()
    }

    @DeleteMapping("/api/profiles/{username}/follow")
    fun unfollowUser(): Profile {
        TODO()
    }
}
