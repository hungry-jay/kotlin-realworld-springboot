package back.model

class Comment(
    val id: Int,
    val createdAt: String,
    val updatedAt: String,
    val body: String,
    val author: User
)
