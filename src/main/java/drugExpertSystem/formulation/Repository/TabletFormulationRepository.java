package drugExpertSystem.formulation.Repository;

import drugExpertSystem.formulation.TabletFormulation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Panupak on 9/30/2014.
 */
@Repository
public interface TabletFormulationRepository extends MongoRepository<TabletFormulation,String> {
}
