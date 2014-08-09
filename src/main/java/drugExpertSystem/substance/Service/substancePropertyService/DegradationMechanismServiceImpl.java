package drugExpertSystem.substance.Service.substancePropertyService;

import drugExpertSystem.substance.DAO.SequeceNumber.SequenceDao;
import drugExpertSystem.substance.Entity.substanceProperty.DegradationMechanism;
import drugExpertSystem.substance.repository.DegradationMechanismRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Panupak on 6/8/2014.
 */
@Service
public class DegradationMechanismServiceImpl implements DegradationMechanismService {
    @Autowired
    DegradationMechanismRepository degradationMechanismRepository;

    @Autowired
    SequenceDao sequenceDao;

    @Override
    @Transactional
    public DegradationMechanism add(DegradationMechanism degradationMechanism) {
        degradationMechanism.setId(sequenceDao.getNextSequenceId("degradationMechanism"));
        degradationMechanismRepository.save(degradationMechanism);
        try {
            this.getByID(degradationMechanism.getId());
        }catch (Exception e){
            return null;
        }

        return degradationMechanism;

    }

    @Override
    @Transactional
    public DegradationMechanism update(DegradationMechanism degradationMechanism) {
        degradationMechanismRepository.save(degradationMechanism);
        try {
            this.getByID(degradationMechanism.getId());
        }catch (Exception e){
            return null;
        }

        return degradationMechanism;
    }

    @Override
    @Transactional
    public DegradationMechanism delete(DegradationMechanism degradationMechanism) {
        degradationMechanismRepository.delete(degradationMechanism);

        return degradationMechanism;
    }

    @Override
    @Transactional
    public List<DegradationMechanism> getAll() {
        return degradationMechanismRepository.findAll();
    }

    @Override
    @Transactional
    public DegradationMechanism getByID(long id) {
        return degradationMechanismRepository.findById(id);
    }

    @Override
    public DegradationMechanism getByType(String type) {
        return degradationMechanismRepository.findByType(type);
    }
}
