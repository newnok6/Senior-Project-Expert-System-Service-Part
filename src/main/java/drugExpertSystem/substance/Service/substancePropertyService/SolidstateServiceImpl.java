package drugExpertSystem.substance.Service.substancePropertyService;

import drugExpertSystem.substance.DAO.SequeceNumber.SequenceDao;
import drugExpertSystem.substance.Entity.substanceProperty.Solidstate;
import drugExpertSystem.substance.repository.SolidstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Panupak on 6/8/2014.
 */
@Service
public class SolidstateServiceImpl implements SolidstateService {
    @Autowired
    SolidstateRepository solidstateRepository;

    @Autowired
    SequenceDao sequenceDao;

    @Override
    @Transactional
    public Solidstate add(Solidstate solidstate) {
        solidstate.setId(sequenceDao.getNextSequenceId("solidstate"));
        solidstateRepository.save(solidstate);

        try{
            this.getByID(solidstate.getId());
        }catch (Exception e){
            return null;
        }

        return solidstate;
    }

    @Override
    @Transactional
    public Solidstate update(Solidstate solidstate) {

        solidstateRepository.save(solidstate);
        try{
            this.getByID(solidstate.getId());
        }catch (Exception e){
            return null;
        }

        return solidstate;
    }

    @Override
    @Transactional
    public Solidstate delete(Solidstate solidstate) {

        solidstateRepository.delete(solidstate);
        return  solidstate;
    }

    @Override
    @Transactional
    public List<Solidstate> getAll() {
        return solidstateRepository.findAll();
    }

    @Override
    @Transactional
    public Solidstate getByID(long id) {
        return solidstateRepository.findById(id);
    }

    @Override
    @Transactional
    public Solidstate getByType(String type) {
        return solidstateRepository.findByType(type);
    }
}
