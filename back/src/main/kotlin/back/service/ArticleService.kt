package back.service

import back.model.Article
import back.repository.ArticleRepository

class ArticleService (private val repository: ArticleRepository) {
    fun findBySlug(slug: String): Article? = repository.findBySlug(slug)

}