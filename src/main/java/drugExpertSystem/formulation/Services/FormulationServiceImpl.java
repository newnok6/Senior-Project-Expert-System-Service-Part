package drugExpertSystem.formulation.Services;

import drugExpertSystem.formulation.Formulation;
import drugExpertSystem.formulation.Repository.FormulationRepository;
import drugExpertSystem.formulation.SolutionFormulation;
import drugExpertSystem.formulation.TabletFormulation;
import drugExpertSystem.substance.DAO.SequeceNumber.SequenceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Panupak on 8/21/2014.
 */
@Service
public class FormulationServiceImpl implements FormulationService {

    @Autowired
    FormulationRepository formulationRepository;

    @Autowired
    SequenceDao sequenceDao;

    @Override
    public Formulation addFormulation(Formulation formulation) {
        //formulation.setId(sequenceDao.getNextSequenceId("formulation"));

        /*
        if(formulation.getType()=="Tablet Formulation"){
            formulationRepository.save((Iterable<Formulation>) new TabletFormulation());
        }else{
            formulationRepository.save((Iterable<Formulation>) new SolutionFormulation());
        }
        */

        try{
            this.getFormulationById(formulation.getId());
        }catch (Exception e){
            return null;
        }
        return formulation;
    }

    @Override
    public Formulation updateFormulation(Formulation formulation) {
        formulationRepository.save(formulation);
        try{
            this.getFormulationById(formulation.getId());
        }catch (Exception e){
            return null;
        }
        return formulation;
    }

    @Override
    public Formulation deleteFormulation(Formulation formulation) {
        return null;
    }

    @Override
    public List getAllFormulation() {
        return formulationRepository.findAll();
    }

    @Override
    public Formulation getFormulationById(long id) {

        return formulationRepository.findById(id);
    }


}
