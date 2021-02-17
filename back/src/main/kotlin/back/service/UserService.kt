package back.service

import back.model.User
import org.springframework.stereotype.Service

@Service
class UserService {

    fun authLogin(email: String, password: String) {
        TODO()
        // 1. email & password auth
    }

    fun authRegister(email: String, password: String) {
        TODO()
    }

    fun currentUser(): User {
        TODO()
    }

    fun getNewToken(): String {
        TODO()
    }

}