package drugExpertSystem.excipient;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Panupak on 7/24/2014.
 */
@Repository
public interface ExcipientRepository extends MongoRepository<Excipient,String> {


}
