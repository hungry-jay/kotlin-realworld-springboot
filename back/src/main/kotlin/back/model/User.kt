package back.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Entity

@Entity
data class User(
    val email: String,
    var token: String = "",
    val username: String,
    @JsonIgnore
    val password: String,
    var bio: String = "",
    var image: String = "",
    @JsonIgnore
    val follows: MutableList<String> = mutableListOf()
)
