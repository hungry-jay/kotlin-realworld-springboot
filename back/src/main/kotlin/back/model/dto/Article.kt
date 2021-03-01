package back.model.dto

import back.model.Tag
import back.model.User
import com.fasterxml.jackson.annotation.JsonRootName
import java.time.ZonedDateTime

@JsonRootName("article")
data class Article(
    val slug: String,
    val title: String,
    val description: String,
    val body: String,
    val tagList: MutableList<Tag> = mutableListOf(),
    val createdAt: ZonedDateTime = ZonedDateTime.now(),
    val updatedAt: ZonedDateTime = ZonedDateTime.now(),
    val favorited: Boolean = false,
    val favoriteCount: Int = 0,
    val author: Profile
) {
    companion object {
        fun from(article: back.model.Article, currentUser: User): Article =
            Article(
                slug = article.slug,
                title = article.title,
                description = article.description,
                body = article.body,
                tagList = article.tagList,
                createdAt = article.createdAt,
                updatedAt = article.updatedAt,
                favorited = article.favored.contains(currentUser),
                favoriteCount = article.favored.size,
                author = Profile.from(article.author, currentUser)
            )
    }
}
