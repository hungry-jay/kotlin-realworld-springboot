package back.handler

import back.model.Article
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping

class ArticleHandler {

    @GetMapping("/api/articles")
    fun getArticles(): Any { // List<Article> + articlesCount
        TODO()
    }

    @GetMapping("/api/articles/feed")
    fun feedArticles(): Any { // List<Article> + articlesCount
        TODO()
    }

    @GetMapping("/api/articles/{slug}")
    fun getArticle(): Article {
        TODO()
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
}
