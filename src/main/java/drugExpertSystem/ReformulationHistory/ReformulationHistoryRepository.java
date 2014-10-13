package drugExpertSystem.ReformulationHistory;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Panupak on 10/11/2014.
 */
@Repository
public interface ReformulationHistoryRepository extends MongoRepository<ReformulationHistory,String> {
}
