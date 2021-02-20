package back.model

import javax.persistence.Entity

@Entity
class Comment(
    val id: Int,
    val createdAt: String,
    val updatedAt: String,
    val body: String,
    val author: User
)
