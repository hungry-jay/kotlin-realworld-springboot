package back.repository

import back.model.Article
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository: CrudRepository<Article, Long> {
    fun findBySlug(slug: String): Article?
}