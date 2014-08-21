package drugExpertSystem.formulation.Repository;

import drugExpertSystem.formulation.Formulation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



/**
 * Created by Panupak on 8/21/2014.
 */
@RepositoryRestResource(collectionResourceRel = "Formulation")
public interface FormulationRepository extends MongoRepository<Formulation,String> {

    Formulation findById(long id);

}
