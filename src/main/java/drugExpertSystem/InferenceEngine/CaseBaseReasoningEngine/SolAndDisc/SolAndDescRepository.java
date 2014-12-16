package drugExpertSystem.InferenceEngine.CaseBaseReasoningEngine.SolAndDisc;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Panupak on 11/10/2014.
 */
@Repository
public interface SolAndDescRepository extends MongoRepository<SolAndDesc,String> {

}
