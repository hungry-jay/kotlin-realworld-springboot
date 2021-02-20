package back.model

class Profile(
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
