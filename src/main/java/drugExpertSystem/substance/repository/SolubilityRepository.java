package drugExpertSystem.substance.repository;

import drugExpertSystem.substance.Entity.substanceProperty.Solubility;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Panupak on 6/8/2014.
 */
@Repository
public interface SolubilityRepository extends MongoRepository<Solubility,String> {
    Solubility findById(long id);
    Solubility findByType(String type);
}
