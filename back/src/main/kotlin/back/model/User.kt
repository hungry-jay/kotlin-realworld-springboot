package back.model

import javax.persistence.Entity

@Entity
data class User(val email: String,
           var token: String = "",
           val username: String,
           val password: String,
           var bio: String = "",
           var image: String = "",
           // 해당 user가 follow 하고있는 list
           val follows: MutableList<String> = mutableListOf()) {

}