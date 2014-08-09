package drugExpertSystem.substance.repository;

import drugExpertSystem.substance.Entity.substanceProperty.Solidstate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Panupak on 6/8/2014.
 */
@Repository
public interface SolidstateRepository extends MongoRepository<Solidstate,String> {
    Solidstate findById(long id);
    Solidstate findByType(String type);
}
