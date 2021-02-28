package back.repository

import back.model.Article
import back.model.User
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository : CrudRepository<Article, Long> {
    fun findBySlug(slug: String): Article?
    fun findByAuthor(author: User, pageRequest: PageRequest): Article?
    fun findAll(pageRequest: PageRequest): Iterable<Article>
    override fun findAll(): Iterable<Article>
}
