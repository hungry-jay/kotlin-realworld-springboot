package back.handler

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TagHandler {

    @GetMapping("/api/tags")
    fun getTags(): List<String> {
        TODO()
    }
}
