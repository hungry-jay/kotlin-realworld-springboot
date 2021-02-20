package back.model.DTO

import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName("user")
data class UpdateUser(
    val email: String? = null,
    val username: String? = null,
    val password: String? = null,
    val image: String? = null,
    val bio: String? = null
)
