package hob.spring.service

import hob.spring.model.User
import hob.spring.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class UserService: InterfaceUserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    operator fun get(id: String): User { // 유저의 id 값을 통해 검색하는 함수
        return userRepository.findById(id).orElse(null)
    }

    override fun subscribeHob(userId: String, hobId: Int): Boolean { //  홉을 구독하는 함수
        var user = userRepository.findById(userId).orElse(null)
        if (user == null) {
            return false
        } else {
            user.subscribeHobIdList.add(hobId)
            userRepository.save(user)
            return true
        }
    }

    override fun cancelHob(userId: String, hobId: Int): Boolean { // 홉 구독취소 하는 함수
        var user = userRepository.findById(userId).orElse(null)
        if (user == null) {
            return false
        } else {
            val indexOfHobId = user.subscribeHobIdList.indexOf(hobId)
            if (indexOfHobId == -1) return false
            user.subscribeHobIdList.removeAt(indexOfHobId)
            userRepository.save(user)
            return true
        }
    }

    override fun create(user: User): User { // 유저를 등록하는 함수
        return userRepository.insert(user)
    }

    val all: List<User> // 유저의 모든 정보를 제공하는 함수
        get() = userRepository.findAll()
}