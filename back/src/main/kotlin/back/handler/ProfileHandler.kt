package back.handler

import back.model.dto.Profile
import back.model.User
import back.service.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProfileHandler(private val service: UserService) {

    @GetMapping("/api/profiles/{username}")
    fun getProfile(@PathVariable userName: String): Map<String, Profile> {
        service.findByUsername(userName)?.let {
            return view(it, service.currentUser())
        }
        throw Error("401 findByUsername error; user not found")
    }

    @PostMapping("/api/profiles/{username}/follow")
    fun followUser(@PathVariable username: String): Map<String, Profile> {
        service.findByUsername(username)?.let {
            val currentUser = service.currentUser()
            if (!currentUser.follows.contains(username)) {
                currentUser.follows.add(username)
                service.save(currentUser)
            }
            return view(it, currentUser)
        }
        throw Error("401 findByUsername error; user not found")
    }

    @DeleteMapping("/api/profiles/{username}/follow")
    fun unfollowUser(@PathVariable username: String): Map<String, Profile> {
        service.findByUsername(username)?.let {
            val currentUser = service.currentUser()
            if (currentUser.follows.contains(username)) {
                currentUser.follows.remove(username)
                service.save(currentUser)
            }
            return view(it, currentUser)
        }
        throw Error("401 findByUsername error; user not found")
    }

    private fun view(user: User, currentUser: User) = mapOf("profile" to Profile.from(user, currentUser))
}
