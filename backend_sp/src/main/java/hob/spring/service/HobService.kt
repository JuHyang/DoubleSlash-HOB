package hob.spring.service

import hob.spring.model.Hob
import hob.spring.repository.HobRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.stereotype.Service

@Service
class HobService: InterfaceHobService {
    @Autowired
    private lateinit var hobRepository: HobRepository
    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    operator fun get(id: String): Hob { // 홉의 id 값을 통해 검색하는 함수
        return hobRepository.findById(id).orElse(null)
    }

    override fun searchByName(hobName: String, index: Int): ArrayList<Hob> { // 홉 이름 검색 함수
        TODO("Not yet implemented")
//        var result = hobRepository.findByName(hobName).subList(index * 8, (index+1) * 8 - 1)
//        return ArrayList(result)
    }

    override fun searchByHobTypeId(hobTypeId: Int, index: Int): ArrayList<Hob> { // 홉 타입 검색 함수
        TODO("Not yet implemented")
    }

    override fun create(hob: Hob): Hob { // 홉을 등록하는 함수
        return hobRepository.insert(hob)
    }

    val all: List<Hob> // 홉의 모든 정보를 제공하는 함수
        get() = hobRepository.findAll()
}