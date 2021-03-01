package back.model

import back.model.dto.Comment
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.ZonedDateTime
import javax.persistence.Entity

@Entity
data class Article(
    val slug: String,
    val title: String,
    val description: String,
    val body: String,
    val tagList: MutableList<Tag> = mutableListOf(),
    val createdAt: ZonedDateTime = ZonedDateTime.now(),
    val updatedAt: ZonedDateTime = ZonedDateTime.now(),
    val favored: MutableList<User> = mutableListOf(),
    val author: User,
    @JsonIgnore
    val comments: MutableList<Comment> = mutableListOf()
)
