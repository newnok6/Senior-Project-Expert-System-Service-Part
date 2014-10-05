package drugExpertSystem.formulation.Repository;

import drugExpertSystem.Model.SolutionFormulation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Panupak on 9/30/2014.
 */
@Repository
public interface SolutionFormulationRepository extends MongoRepository<SolutionFormulation,String> {
}
