package back.handler

import back.model.Comment
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

class CommentHandler {

    @PostMapping("/api/articles/{slug}/comments")
    fun addComment(): Comment {
        TODO()
    }

    @GetMapping("/api/articles/{slug}/comments")
    fun getComments(): List<Comment> {
        TODO()
    }

    @DeleteMapping("/api/articles/{slug}/comments/{id}")
    fun deleteComment(): Void {
        TODO()
    }
}
