package back.service

import back.model.Article
import back.model.User
import back.model.dto.Comment
import back.model.dto.NewArticle
import back.model.dto.NewComment
import back.model.dto.UpdateArticle
import back.repository.ArticleRepository
import com.github.slugify.Slugify
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.time.ZonedDateTime

@Service
class ArticleService(private val repository: ArticleRepository) {
    fun findAll(page: PageRequest): List<Article>? = repository.findAll(page).toList()

    fun findByAuthor(author: User, page: PageRequest) = repository.findByAuthor(author, page)

    fun findBySlug(slug: String): Article? = repository.findBySlug(slug)

    fun registerArticle(currentUser: User, slug: String, newArticle: NewArticle): Article =
        repository.save(
            Article(
                slug = slug,
                title = newArticle.title,
                description = newArticle.description,
                body = newArticle.body,
                tagList = newArticle.tagList,
                author = currentUser,
            )
        )

    fun getNewSlug(title: String): String = Slugify().slugify(title)

    fun update(currentArticle: Article, updateArticle: UpdateArticle): Article {
        var newSlug: String? = null
        if (updateArticle.title != null && currentArticle.title != updateArticle.title) {
            newSlug = getNewSlug(updateArticle.title)
        }

        val updatedArticle = currentArticle.copy(
            title = updateArticle.title ?: currentArticle.title,
            description = updateArticle.description ?: currentArticle.description,
            body = updateArticle.body ?: currentArticle.body,
            slug = newSlug ?: currentArticle.slug,
            updatedAt = ZonedDateTime.now()
        )

        return repository.save(updatedArticle)
    }

    fun delete(slug: String) =
        repository.findBySlug(slug)?.let {
            repository.delete(it)
        }

    fun addFavored(article: Article, currentUser: User): Article {
        if (!article.favored.contains(currentUser)) {
            article.favored.add(currentUser)
        }
        return repository.save(article)
    }

    fun deleteFavored(article: Article, currentUser: User): Article {
        if (article.favored.contains(currentUser)) {
            article.favored.remove(currentUser)
        }
        return repository.save(article)
    }

    fun registerComment(
        article: Article,
        newComment: NewComment,
        currentUser: User
    ): Comment {
        val comment = Comment(
            body = newComment.body,
            author = currentUser
        )
        article.comments.add(comment)
        repository.save(article)
        return comment
    }

    fun getComments(article: Article): List<Comment> = article.comments.toList()

    fun deleteComment(article: Article, id: Long) {
        article.comments.removeIf { it.id == id }
        repository.save(article)
    }
}
