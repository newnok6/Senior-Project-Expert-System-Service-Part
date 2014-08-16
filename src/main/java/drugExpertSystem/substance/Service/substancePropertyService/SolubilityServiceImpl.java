package drugExpertSystem.substance.Service.substancePropertyService;

import drugExpertSystem.substance.DAO.SequeceNumber.SequenceDao;
import drugExpertSystem.substance.Entity.substanceProperty.Solubility;

import drugExpertSystem.substance.repository.SolidstateRepository;
import drugExpertSystem.substance.repository.SolubilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Panupak on 5/22/2014.
 */
@Service
public class SolubilityServiceImpl implements SolubilityService {

    @Autowired
    SolubilityRepository solubilityRepository;


    @Autowired
    SequenceDao sequenceDao;


    @Override
    @Transactional
    public Solubility add(Solubility solubility) {
        solubility.setId(sequenceDao.getNextSequenceId("solubility"));
        solubilityRepository.save(solubility);

        try{
            this.getByID(solubility.getId());
        }catch (Exception e){
            return null;
        }

        return solubility;

    }




    @Override
    @Transactional
    public Solubility update(Solubility solubility) {
        solubilityRepository.save(solubility);
        try{
            this.getByID(solubility.getId());
        }catch (Exception e){
            return null;
        }

        return solubility;
    }

    @Override
    @Transactional
    public Solubility delete(Solubility solubility) {

        solubilityRepository.delete(solubility);
        return solubility;
    }

    @Override
    @Transactional
    public List<Solubility> getAll() {

        return solubilityRepository.findAll();
    }

    @Override
    @Transactional
    public Solubility getByID(long id) {

        return solubilityRepository.findById(id);
    }

    @Override
    @Transactional
    public Solubility getByType(String type) {

        return solubilityRepository.findByType(type);
    }

}
