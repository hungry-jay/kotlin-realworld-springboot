package back.handler

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping

class ArticleHandler {

    @GetMapping("/api/articles")
    fun getArticles() {
        TODO()
    }

    @GetMapping("/api/articles/feed")
    fun feedArticles() {
        TODO()
    }

    @GetMapping("/api/articles/{slug}")
    fun getArticle() {
        TODO()
    }

    @PostMapping("/api/articles")
    fun createArticle() {
        TODO()
    }

    @PutMapping("/api/articles/{slug}")
    fun updateArticle() {
        TODO()
    }

    @DeleteMapping("/api/articles/{slug}")
    fun deleteArticle() {
        TODO()
    }

    @PostMapping("/api/articles/{slug}/favorite")
    fun favoriteArticle() {
        TODO()
    }

    @DeleteMapping("/api/articles/{slug}/favorite")
    fun unfavoriteArticle() {
        TODO()
    }
}
