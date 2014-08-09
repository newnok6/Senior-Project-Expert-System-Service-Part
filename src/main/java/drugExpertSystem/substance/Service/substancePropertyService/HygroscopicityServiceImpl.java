package drugExpertSystem.substance.Service.substancePropertyService;

import drugExpertSystem.substance.DAO.SequeceNumber.SequenceDao;
import drugExpertSystem.substance.Entity.substanceProperty.Hygroscopicity;
import drugExpertSystem.substance.repository.HygroscopicityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Panupak on 6/8/2014.
 */
@Service
public class HygroscopicityServiceImpl implements HygroscopicityService {
    @Autowired
    HygroscopicityRepository hygroscopicityRepository;

    @Autowired
    SequenceDao sequenceDao;

    @Override
    @Transactional
    public Hygroscopicity add(Hygroscopicity hygroscopicity) {
        hygroscopicity.setId(sequenceDao.getNextSequenceId("hygroscopicity"));
        hygroscopicityRepository.save(hygroscopicity);

        try{
            this.getByID(hygroscopicity.getId());
        }catch (Exception e){
            return null;
        }

        return hygroscopicity;
    }

    @Override
    @Transactional
    public Hygroscopicity update(Hygroscopicity hygroscopicity) {

        hygroscopicityRepository.save(hygroscopicity);
        try{
            this.getByID(hygroscopicity.getId());
        }catch (Exception e){
            return null;
        }

        return hygroscopicity;
    }

    @Override
    @Transactional
    public Hygroscopicity delete(Hygroscopicity hygroscopicity) {

        hygroscopicityRepository.delete(hygroscopicity);
        return hygroscopicity;
    }

    @Override
    @Transactional
    public List<Hygroscopicity> getAll() {
        return hygroscopicityRepository.findAll();
    }

    @Override
    @Transactional
    public Hygroscopicity getByID(long id) {
        return hygroscopicityRepository.findById(id);
    }

    @Override
    @Transactional
    public Hygroscopicity getByType(String type) {
        return hygroscopicityRepository.findByType(type);
    }
}
