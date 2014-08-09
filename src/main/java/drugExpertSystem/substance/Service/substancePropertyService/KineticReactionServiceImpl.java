package drugExpertSystem.substance.Service.substancePropertyService;

import drugExpertSystem.substance.DAO.SequeceNumber.SequenceDao;
import drugExpertSystem.substance.Entity.substanceProperty.KineticReaction;
import drugExpertSystem.substance.repository.KineticReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Panupak on 6/8/2014.
 */
@Service
public class KineticReactionServiceImpl implements KineticReactionService {
    @Autowired
    KineticReactionRepository kineticReactionRepository;

    @Autowired
    SequenceDao sequenceDao;

    @Override
    @Transactional
    public KineticReaction add(KineticReaction kineticReaction) {
        kineticReaction.setId(sequenceDao.getNextSequenceId("kineticReaction"));
        kineticReactionRepository.save(kineticReaction);

        try{
            this.getByID(kineticReaction.getId());
        }catch (Exception e){
            return null;
        }

        return kineticReaction;
    }

    @Override
    @Transactional
    public KineticReaction update(KineticReaction kineticReaction) {

        kineticReactionRepository.save(kineticReaction);

        try{
            this.getByID(kineticReaction.getId());
        }catch (Exception e){
            return null;
        }

        return kineticReaction;
    }

    @Override
    @Transactional
    public KineticReaction delete(KineticReaction kineticReaction) {
        kineticReactionRepository.delete(kineticReaction);

        return kineticReaction;
    }

    @Override
    @Transactional
    public List<KineticReaction> getAll() {
        return kineticReactionRepository.findAll();
    }

    @Override
    @Transactional
    public KineticReaction getByID(long id) {
        return kineticReactionRepository.findById(id);
    }

    @Override
    @Transactional
    public KineticReaction getByType(String type) {
        return kineticReactionRepository.findByType(type);
    }
}
