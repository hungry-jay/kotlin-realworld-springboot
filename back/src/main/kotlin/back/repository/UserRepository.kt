package back.repository

import back.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {
//    count()	개수 확인
//    delete()	1건 또는 여러 건 삭제
//    deleteAll()	모두 삭제
//    exists()	ID 있는지 확인
//    findAll()	전체 또는 ID목록으로 조회
//    findOne()	ID로 조회
//    save()	1건 또는 여러 건 저장 return 저장한것

    fun findByEmail(email: String): User?
    fun existsByEmail(email: String): Boolean
    fun existsByUsername(email: String): Boolean
}