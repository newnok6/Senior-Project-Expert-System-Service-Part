package drugExpertSystem.substance.repository;

import drugExpertSystem.substance.Entity.substanceProperty.ParticleSize;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Panupak on 6/8/2014.
 */
@Repository
public interface ParticleSizeRepository extends MongoRepository<ParticleSize,String> {
    ParticleSize findById(long id);
    ParticleSize findByType(String type);
}
