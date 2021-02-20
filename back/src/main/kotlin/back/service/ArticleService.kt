package back.service

import back.model.Article
import back.model.User
import back.model.dto.NewArticle
import back.repository.ArticleRepository
import com.github.slugify.Slugify
import org.springframework.stereotype.Service

@Service
class ArticleService (private val repository: ArticleRepository) {
    fun findBySlug(slug: String): Article? = repository.findBySlug(slug)

    fun register(currentUser: User, newArticle: NewArticle): Article {
        val slug = getNewSlug(newArticle.title)

        val article = Article(
            slug = slug,
            title = newArticle.title,
            description = newArticle.description,
            body = newArticle.body,
            tagList = newArticle.tagList,
            author = currentUser,
        )

        return repository.save(article)
    }

    private fun getNewSlug(title: String): String = Slugify().slugify(title)
}