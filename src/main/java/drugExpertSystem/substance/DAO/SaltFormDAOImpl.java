package drugExpertSystem.substance.DAO;

import drugExpertSystem.substance.DAO.SequeceNumber.SequenceDao;
import drugExpertSystem.substance.Entity.SubstancePackage.SaltForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Panupak on 5/21/2014.
 */
@Repository
public class SaltFormDAOImpl implements SaltFormDAO {

    @Autowired
    private MongoTemplate mongoTemplate;
    public static final String COLLECTION_NAME = "solubility";

    @Autowired
    private SequenceDao sequenceDao;

    @Override
    public void addSaltForm(SaltForm saltForm) {
        if (!mongoTemplate.collectionExists(SaltForm.class)) {
            mongoTemplate.createCollection(SaltForm.class);
        }

        mongoTemplate.insert(saltForm, COLLECTION_NAME);
    }



    @Override
    public void editSaltForm(SaltForm saltForm) {

    }

    @Override
    public void deleteSaltForm(SaltForm saltForm) {

    }

    @Override
    public SaltForm getSaltForm(long id) {

        return mongoTemplate.findById(id,SaltForm.class);
    }

    @Override
    public List<SaltForm> getAllSaltForm() {
        return null;
    }

    @Override
    public SaltForm getSaltFormByName() {
        return null;
    }
}
