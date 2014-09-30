package drugExpertSystem.excipient.services;

import drugExpertSystem.excipient.Excipient;
import drugExpertSystem.excipient.ExcipientRepository;
import drugExpertSystem.substance.DAO.SequeceNumber.SequenceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Panupak on 9/24/2014.
 */
@Service
public class ExcipientServiceImpl implements ExcipientService {

    @Autowired
    ExcipientRepository excipientRepository;

    @Autowired
    SequenceDao sequenceDao;

    @Override
    @Transactional
    public Excipient addExcipient(Excipient excipient) {
        excipient.setId(sequenceDao.getNextSequenceId("excipient"));
        excipientRepository.save(excipient);
        try{
            this.getExcipientById(excipient.getId());
        }catch (Exception e){
            return null;
        }
        return excipient;
    }

    @Override
    @Transactional
    public Excipient updateExcipient(Excipient excipient) {
        Excipient setdbExcipient = excipientRepository.findById(excipient.getId());
        setdbExcipient.setMinWeight(excipient.getMinWeight());
        setdbExcipient.setMaxWeight(excipient.getMaxWeight());
        setdbExcipient.setUsedWeight(excipient.getUsedWeight());
        setdbExcipient.setSubstanceFunctions(excipient.getSubstanceFunctions());
        excipientRepository.save(excipient);
        try{
            this.getExcipientById(excipient.getId());
        }catch (Exception e){
            return null;
        }
        return excipient;
    }

    @Override
    @Transactional
    public Excipient deleteExcipient(Excipient excipient) {
        excipientRepository.delete(excipient);
        return excipient;
    }

    @Override
    @Transactional
    public List getAllExcipient() {
        return excipientRepository.findAll();
    }

    @Override
    @Transactional
    public Excipient getExcipientById(long id) {
        return excipientRepository.findById(id);
    }


}
