package back.handler

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

class CommentHandler {

    @PostMapping("/api/articles/{slug}/comments")
    fun addComment() {
    }

    @GetMapping("/api/articles/{slug}/comments")
    fun getComments() {
    }

    @DeleteMapping("/api/articles/{slug}/comments/{id}")
    fun deleteComment() {
    }
}
