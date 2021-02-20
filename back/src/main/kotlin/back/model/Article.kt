package back.model

import javax.persistence.Entity

@Entity
class Article(
    val slug: String,
    val title: String,
    val description: String,
    val body: String,
    val tagList: List<String>,
    val createdAt: String,
    val updatedAt: String,
    val favoritesCount: Int,
    val author: User
)
