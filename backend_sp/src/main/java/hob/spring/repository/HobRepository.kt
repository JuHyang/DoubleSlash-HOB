package hob.spring.repository

import hob.spring.model.Hob
import org.springframework.data.mongodb.repository.MongoRepository

interface HobRepository : MongoRepository<Hob, String>