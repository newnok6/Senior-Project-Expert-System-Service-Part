package drugExpertSystem.formulation.Repository;

import drugExpertSystem.formulation.Formulation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by Panupak on 8/21/2014.
 */
@Repository
public interface FormulationRepository extends MongoRepository<Formulation,String> {

    Formulation findById(long id);

}
