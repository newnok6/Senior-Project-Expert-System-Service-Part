package drugExpertSystem.substance.repository;

import drugExpertSystem.substance.Entity.SubstanceFunction.CompoundFunction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Panupak on 6/8/2014.
 */
@Repository
public interface CompoundFunctionRepository extends MongoRepository<CompoundFunction,String> {
    CompoundFunction findById(long id);
    CompoundFunction findByType(String type);
}
