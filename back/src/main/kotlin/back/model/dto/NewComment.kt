package back.model.dto

import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName("comment")
data class NewComment(
    val body: String
)
