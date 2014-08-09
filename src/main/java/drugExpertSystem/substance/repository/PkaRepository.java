package drugExpertSystem.substance.repository;

import drugExpertSystem.substance.Entity.substanceProperty.Pka;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Panupak on 6/8/2014.
 */
@Repository
public interface PkaRepository extends MongoRepository<Pka,String> {
    Pka findById(long id);
    Pka findByType(String type);
}
