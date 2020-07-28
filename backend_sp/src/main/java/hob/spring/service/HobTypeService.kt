package hob.spring.service

import hob.spring.model.HobType
import hob.spring.repository.HobTypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HobTypeService: InterfaceHobTypeService {
    @Autowired
    private lateinit var hobTypeRepository: HobTypeRepository

    operator fun get(id: String): HobType { // 홉 타입 의 id 값을 통해 검색하는 함수
        return hobTypeRepository.findById(id).orElse(null)
    }

    override fun create(hobType: HobType): HobType { // 홉 타입 을 등록하는 함수
        return hobTypeRepository.insert(hobType)
    }

    val all: List<HobType> // 홉 타입 의 모든 정보를 제공하는 함수
        get() = hobTypeRepository.findAll()
}