package hob.spring.repository

import hob.spring.model.HobType
import org.springframework.data.mongodb.repository.MongoRepository

interface HobTypeRepository : MongoRepository<HobType, String>