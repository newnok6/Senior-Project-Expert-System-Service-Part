package drugExpertSystem.substance.DAO.SequeceNumber;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by Panupak on 5/24/2014.
 */
@Repository
public class SequenceDAOImpl implements SequenceDao {
    @Autowired
    private MongoOperations mongoOperation;

    @Autowired
    private MongoTemplate mongoTemplate;
    public static final String COLLECTION_NAME = "sequence";
    @Override
    public long getNextSequenceId(String key) throws SequenceException {

        if (!mongoTemplate.collectionExists(SequenceId.class)) {
            mongoTemplate.createCollection(SequenceId.class);


        }

            //get sequence id
            Query query = new Query(Criteria.where("_id").is(key));

            if (query.getFieldsObject()==null){
                 SequenceId sequenceId = new SequenceId();
                 sequenceId.setId(key);
                 sequenceId.setSeq(0);
                 mongoTemplate.insert(sequenceId,COLLECTION_NAME);
             }

            //increase sequence id by 1
            Update update = new Update();
            update.inc("seq", 1);

            //return new increased id
            FindAndModifyOptions options = new FindAndModifyOptions();
            options.returnNew(true);

            //this is the magic happened.
            SequenceId seqId =
                    mongoOperation.findAndModify(query, update, options, SequenceId.class);

            //if no id, throws SequenceException
            //optional, just a way to tell user when the sequence id is failed to generate.
            if (seqId == null) {
                throw new SequenceException("Unable to get sequence id for key : " + key);
            }

            return seqId.getSeq();
        }
    }

