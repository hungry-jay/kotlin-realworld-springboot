package back.handler

import back.service.TagService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TagHandler(val service: TagService) {

    @GetMapping("/api/tags")
    fun getTags() = mapOf("tags" to service.getTags().map { it.body })
}
