package drugExpertSystem.formulation.Repository;

import drugExpertSystem.formulation.Formulation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Panupak on 10/12/2014.
 */
@Repository
public interface FormulationRepository extends MongoRepository<Formulation,String> {

}
