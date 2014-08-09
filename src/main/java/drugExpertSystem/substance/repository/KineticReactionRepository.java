package drugExpertSystem.substance.repository;

import drugExpertSystem.substance.Entity.substanceProperty.KineticReaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Panupak on 6/8/2014.
 */
@Repository
public interface KineticReactionRepository extends MongoRepository<KineticReaction,String> {
    KineticReaction findById(long id);
    KineticReaction findByType(String type);
}
