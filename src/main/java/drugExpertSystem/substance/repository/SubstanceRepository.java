package drugExpertSystem.substance.repository;


import drugExpertSystem.substance.Substance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Panupak on 6/8/2014.
 */
@Repository
public interface SubstanceRepository extends MongoRepository<Substance,String> {


}
