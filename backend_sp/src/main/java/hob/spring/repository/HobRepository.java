package hob.spring.repository;

import hob.spring.model.Hob;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HobRepository extends MongoRepository<Hob, String> {
}
