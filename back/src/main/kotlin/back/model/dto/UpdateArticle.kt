package back.model.dto

import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName("article")
data class UpdateArticle(
    val title: String? = null,
    val description: String? = null,
    val body: String? = null,
    val slug: String? = null
)
