package back.model

import java.time.ZonedDateTime
import javax.persistence.Entity

@Entity
class Article(
    val slug: String,
    val title: String,
    val description: String,
    val body: String,
    val tagList: MutableList<String> = mutableListOf(),
    val createdAt: ZonedDateTime = ZonedDateTime.now(),
    val updatedAt: ZonedDateTime = ZonedDateTime.now(),
    var favoritesCount: Int = 0,
    val author: User
)
