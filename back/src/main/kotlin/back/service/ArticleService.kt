package back.service

import back.model.Article
import back.repository.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService (private val repository: ArticleRepository) {
    fun findBySlug(slug: String): Article? = repository.findBySlug(slug)

}