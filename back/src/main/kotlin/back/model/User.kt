package back.model

class User(val email: String,
           var token: String = "",
           val username: String,
           val password: String,
           var bio: String = "",
           var image: String = "") {

}