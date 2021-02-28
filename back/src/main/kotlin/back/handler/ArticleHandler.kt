package back.handler

import back.model.Article
import back.model.dto.NewArticle
import back.service.ArticleService
import back.service.UserService
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ArticleHandler(
    val articleService: ArticleService,
    val userService: UserService
) {

    @GetMapping("/api/articles")
    fun getArticles(
        @RequestParam tag: String,
        @RequestParam author: String,
        @RequestParam favorited: String,
        @RequestParam(defaultValue = "20") limit: Int,
        @RequestParam(defaultValue = "0") offset: Int
    ): Map<String, List<Article>> {

        val page = PageRequest.of(offset, limit, Sort.Direction.DESC, "createdAt")

        articleService.findAll(page)?.let {
            return articlesView(it)
        }
        throw Error("401 findAll error; articles not found")
    }

    @GetMapping("/api/articles/feed")
    fun feedArticles(
        @RequestParam(defaultValue = "20") limit: Int,
        @RequestParam(defaultValue = "0") offset: Int
    ): Map<String, List<Article>> {
        val page = PageRequest.of(offset, limit, Sort.Direction.DESC, "createdAt")

        val currentUser = userService.currentUser()

        val articles = currentUser.follows.map { it ->
            val user = userService.findByUsername(it) ?: throw Error("401 findUser error; user not found")
            articleService.findByAuthor(user, page) ?: throw Error("401 findArticle error; article not found")
        }

        return articlesView(articles)
    }

    @GetMapping("/api/articles/{slug}")
    fun getArticle(@PathVariable slug: String): Map<String, Article> {
        articleService.findBySlug(slug)?.let {
            return articleView(it)
        }
        throw Error("401 findBySlug error; article not found")
    }

    @PostMapping("/api/articles")
    fun createArticle(@RequestBody newArticle: NewArticle): Map<String, Article> =
        userService.currentUser().let {
            val slug = articleService.getNewSlug(newArticle.title)
            return articleView(articleService.register(it, slug, newArticle))
        }

    @PutMapping("/api/articles/{slug}")
    fun updateArticle(): Article {
        TODO()
    }

    @DeleteMapping("/api/articles/{slug}")
    fun deleteArticle(@PathVariable slug: String): Void {
        val currentUser = userService.currentUser()
        articleService.findBySlug(slug)?.let {
            if (it.author != currentUser)
                throw Error("auth error")

            articleService.delete(slug = slug)
        }
        throw Error("401 findBySlug error; article not found")
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

    fun articlesView(articles: List<Article>) = mapOf("articles" to articles)
}
