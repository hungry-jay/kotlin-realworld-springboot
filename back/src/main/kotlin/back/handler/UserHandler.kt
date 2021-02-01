package back.handler

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping

class UserHandler {

    @PostMapping("/api/users/login")
    fun authenticate() {
        TODO()
    }

    @PostMapping("/api/users")
    fun register() {
        TODO()
    }

    @GetMapping("/api/user")
    fun getCurrentUser() {
        TODO()
    }

    @PutMapping("api/user")
    fun updateUser() {
        TODO()
    }

    @GetMapping("/api/profiles/{username}")
    fun getProfile() {
        TODO()
    }

    @PostMapping("/api/profiles/{username}/follow")
    fun followUser() {
        TODO()
    }

    @DeleteMapping("/api/profiles/{username}/follow")
    fun unfollowUser() {
        TODO()
    }
}
