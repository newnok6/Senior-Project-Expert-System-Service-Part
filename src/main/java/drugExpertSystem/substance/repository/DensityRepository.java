package drugExpertSystem.substance.repository;

import drugExpertSystem.substance.Entity.substanceProperty.Density;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Panupak on 6/8/2014.
 */
@Repository
public interface DensityRepository extends MongoRepository<Density,String> {
   Density findById(long id);
    Density findByType(String type);
}
