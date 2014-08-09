package drugExpertSystem.substance.repository;

import drugExpertSystem.substance.Entity.substanceProperty.Hygroscopicity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Panupak on 6/8/2014.
 */
@Repository
public interface HygroscopicityRepository extends MongoRepository<Hygroscopicity,String> {
    Hygroscopicity findById(long id);
    Hygroscopicity findByType(String type);
}
