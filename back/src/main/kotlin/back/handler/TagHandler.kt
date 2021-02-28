package back.handler

import back.service.ArticleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TagHandler (val service: ArticleService){

    @GetMapping("/api/tags")
    fun getTags() = mapOf("tags" to service.getTags())
}
