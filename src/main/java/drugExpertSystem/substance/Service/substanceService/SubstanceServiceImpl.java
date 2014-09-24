package drugExpertSystem.substance.Service.substanceService;

import drugExpertSystem.substance.DAO.SequeceNumber.SequenceDao;
import drugExpertSystem.substance.Entity.SubstancePackage.Substance;
import drugExpertSystem.substance.repository.SubstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Panupak on 6/8/2014.
 */
@Service
public class SubstanceServiceImpl implements SubstanceService {

    @Autowired
    SubstanceRepository substanceRepository;

    @Autowired
    SequenceDao sequenceDao;

    @Override
    @Transactional
    public Substance addsubstance(Substance substance) {
        substance.setId(sequenceDao.getNextSequenceId("substance"));
        substanceRepository.save(substance);
        try{
            this.getSubstanceById(substance.getId());
        }catch (Exception e){
            return null;
        }
        return substance;
    }

    @Override
    @Transactional
    public Substance updateSubstance(Substance substance) {

        substanceRepository.save(substance);
        try{
            this.getSubstanceById(substance.getId());
        }catch (Exception e){
            return null;
        }
        return substance;
    }

    @Override
    @Transactional
    public Substance deleteSubstance(Substance substance) {

        substanceRepository.delete(substance);

        return substance;
    }

    @Override
    @Transactional
    public List getAllSubstance() {
        return substanceRepository.findAll();
    }

    @Override
    @Transactional
    public Substance getSubstanceById(long id) {
        return substanceRepository.findById(id);
    }

    @Override
    @Transactional
    public Substance getSubstanceByName(String name) {
        return substanceRepository.findByName(name);
    }
}
