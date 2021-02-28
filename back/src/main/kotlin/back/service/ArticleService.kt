package back.service

import back.model.Article
import back.model.User
import back.model.dto.NewArticle
import back.repository.ArticleRepository
import com.github.slugify.Slugify
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class ArticleService(private val repository: ArticleRepository) {
    fun findAll(page: PageRequest): List<Article>? {
        val articles: MutableList<Article> = mutableListOf()
        repository.findAll(page).map {
            articles.add(it)
        }
        return articles.toList()
    }

    fun findByAuthor(author: User, page: PageRequest) = repository.findByAuthor(author, page)

    fun findBySlug(slug: String): Article? = repository.findBySlug(slug)

    fun register(currentUser: User, slug: String, newArticle: NewArticle): Article =
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

    fun delete(slug: String) =
        repository.findBySlug(slug)?.let {
            repository.delete(it)
        }
}
