package back.handler

import back.model.Profile
import back.service.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

class ProfileHandler(private val service: UserService) {

    @GetMapping("/api/profiles/{username}")
    fun getProfile(@PathVariable userName: String): Profile {
        service.findByUsername(userName)?.let {
            return Profile.from(it, service.currentUser())
        }
        throw Error("401 findByUsername error; user not found")
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