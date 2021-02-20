package back.handler

import back.model.Article
import back.service.ArticleService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ArticleHandler (val service: ArticleService) {

    @GetMapping("/api/articles")
    fun getArticles(): Any { // List<Article> + articlesCount
        TODO()
    }

    @GetMapping("/api/articles/feed")
    fun feedArticles(): Any { // List<Article> + articlesCount
        TODO()
    }

    @GetMapping("/api/articles/{slug}")
    fun getArticle(@PathVariable slug: String): Map<String, Article> {
        service.findBySlug(slug)?.let {
            return articleView(it)
        }
        throw Error("401 findBySlug error; article not found")
    }

    @PostMapping("/api/articles")
    fun createArticle(): Article {
        TODO()
    }

    @PutMapping("/api/articles/{slug}")
    fun updateArticle(): Article {
        TODO()
    }

    @DeleteMapping("/api/articles/{slug}")
    fun deleteArticle(): Void {
        TODO()
    }

    @PostMapping("/api/articles/{slug}/favorite")
    fun favoriteArticle(): Article {
        TODO()
    }

    @DeleteMapping("/api/articles/{slug}/favorite")
    fun unfavoriteArticle(): Article {
        TODO()
    }

    fun articleView(article: Article) = mapOf("article" to article)

    fun articlesView(articles: List<Article>) = mapOf("article" to articles)
}
