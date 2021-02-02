package back.handler

import org.springframework.web.bind.annotation.GetMapping

class TagHandler {

    @GetMapping("/api/tags")
    fun getTags(): List<String> {
        TODO()
    }
}
