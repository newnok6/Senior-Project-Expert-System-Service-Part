package drugExpertSystem.substance.Service.substancePropertyService;

import drugExpertSystem.substance.DAO.SequeceNumber.SequenceDao;
import drugExpertSystem.substance.Entity.substanceProperty.Pka;
import drugExpertSystem.substance.repository.PkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Panupak on 6/8/2014.
 */
@Service
public class PkaServiceImpl implements PkaService {
    @Autowired
    PkaRepository pkaRepository;

    @Autowired
    SequenceDao sequenceDao;

    @Override
    @Transactional
    public Pka add(Pka pka) {
     pka.setId(sequenceDao.getNextSequenceId("pka"));
     pkaRepository.save(pka);

        try{
            this.getByID(pka.getId());
        }catch (Exception e){
            return null;
        }

        return pka;
    }

    @Override
    @Transactional
    public Pka update(Pka pka) {

        pkaRepository.save(pka);
        try{
            this.getByID(pka.getId());
        }catch (Exception e){
            return null;
        }

        return pka;
    }

    @Override
    @Transactional
    public Pka delete(Pka pka) {

        pkaRepository.delete(pka);
        return pka;
    }

    @Override
    @Transactional
    public List<Pka> getAll() {
        return pkaRepository.findAll();
    }

    @Override
    @Transactional
    public Pka getByID(long id) {

        return pkaRepository.findById(id);
    }

    @Override
    @Transactional
    public Pka getByType(String type) {

        return pkaRepository.findByType(type);
    }
}
