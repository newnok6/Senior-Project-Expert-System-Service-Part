package drugExpertSystem.Production;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Panupak on 10/7/2014.
 */
@Repository
public interface ProductionRepository extends MongoRepository<Production,String> {
}
