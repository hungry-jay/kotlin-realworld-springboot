package back.model

import javax.persistence.Entity

@Entity
data class Tag(
    val body: String
)
