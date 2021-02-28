package back.model.dto

import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName("article")
data class NewArticle(
    val title: String,
    val description: String,
    val body: String,
    val tagList: MutableList<String> = mutableListOf()
)
