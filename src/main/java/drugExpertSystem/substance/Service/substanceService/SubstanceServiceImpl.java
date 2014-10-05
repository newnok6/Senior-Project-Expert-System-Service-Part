package drugExpertSystem.substance.Service.substanceService;

import drugExpertSystem.Model.Substance;
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



   // @Autowired
    //SequenceDao sequenceDao;

    @Override
    @Transactional
    public Substance addsubstance(Substance substance) {

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

        Substance substanceInDb = substanceRepository.findOne(substance.getId());
        substanceInDb.setName(substance.getName());
        substanceInDb.setWaterSolubility(substance.getWaterSolubility());
        substanceInDb.setStability(substance.getStability());
        substanceInDb.setPka(substance.getPka());
        substanceInDb.setPartitionCoefficient(substance.getPartitionCoefficient());
        substanceInDb.setSolidState(substance.getSolidState());
        substanceInDb.setHygroscopicity(substance.getHygroscopicity());
        substanceInDb.setParticleSize(substance.getParticleSize());
        substanceInDb.setAlcoholSolubility(substance.getAlcoholSolubility());
        substanceInDb.setFlowability(substance.getFlowability());
        substanceInDb.setDensity(substance.getDensity());
        substanceInDb.setSaltForm(substance.getSaltForm());
        substanceInDb.setMocularWeight(substance.getMocularWeight());
        substanceInDb.setIonicity(substance.getIonicity());



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
    public Substance getSubstanceById(String  id) {
        return substanceRepository.findOne(id);
    }




}
