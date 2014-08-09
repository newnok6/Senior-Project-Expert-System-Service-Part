package drugExpertSystem.substance.repository;

import drugExpertSystem.substance.Entity.substanceProperty.DegradationMechanism;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Panupak on 6/8/2014.
 */
@Repository
public interface DegradationMechanismRepository extends MongoRepository<DegradationMechanism,String> {

    DegradationMechanism findById(long id);
    DegradationMechanism findByType(String type);
}
