package hob.spring.repository;

import hob.spring.model.HobType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HobTypeRepository extends MongoRepository<HobType, String> {
}
