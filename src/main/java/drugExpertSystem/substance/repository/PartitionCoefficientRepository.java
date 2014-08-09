package drugExpertSystem.substance.repository;

import drugExpertSystem.substance.Entity.substanceProperty.PartitionCoefficient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Panupak on 6/8/2014.
 */
@Repository
public interface PartitionCoefficientRepository extends MongoRepository<PartitionCoefficient,String> {
    PartitionCoefficient findById(long id);
    PartitionCoefficient findByType(String type);
}
