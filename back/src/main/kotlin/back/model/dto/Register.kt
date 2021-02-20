package back.model.dto

import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName("user")
data class Register(
    val username: String,
    val email: String,
    val password: String
)
