package back.model

import java.time.ZonedDateTime
import javax.persistence.Entity

@Entity
data class Article(
    val slug: String,
    val title: String,
    val description: String,
    val body: String,
    val tagList: MutableList<String> = mutableListOf(),
    val createdAt: ZonedDateTime = ZonedDateTime.now(),
    val updatedAt: ZonedDateTime = ZonedDateTime.now(),
    val favored: MutableList<User> = mutableListOf(),
    val author: User
)
