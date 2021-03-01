package back.model.dto

import back.model.User
import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName("profile")
data class Profile(
    val username: String,
    val bio: String,
    val image: String,
    val following: Boolean
) {
    companion object {
        fun from(user: User, currentUser: User): Profile =
            Profile(
                user.username,
                user.bio,
                user.image,
                currentUser.follows.contains(user.username)
            )
    }
}
