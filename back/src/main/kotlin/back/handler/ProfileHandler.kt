package back.handler

import back.model.Profile
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

class ProfileHandler {

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