package back.handler

import back.model.Comment
import back.model.dto.NewComment
import back.service.ArticleService
import back.service.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CommentHandler (
    val articleService: ArticleService,
    val userService: UserService){

    @PostMapping("/api/articles/{slug}/comments")
    fun addComment(
        @PathVariable slug: String,
        @RequestBody newComment: NewComment
    ): Map<String, Comment> {
        articleService.findBySlug(slug)?.let {
            val comment = articleService.registerComment(
                article = it,
                newComment = newComment,
                currentUser = userService.currentUser())
            return commentView(comment)
        }
        throw Error("401 findBySlug error; article not found")
    }

    @GetMapping("/api/articles/{slug}/comments")
    fun getComments(): List<Comment> {
        TODO()
    }

    @DeleteMapping("/api/articles/{slug}/comments/{id}")
    fun deleteComment(): Void {
        TODO()
    }

    private fun commentView(comment: Comment) = mapOf("comment" to comment)

    private fun commentsView(comments: List<Comment>) = mapOf("comments" to comments)
}
