package drugExpertSystem.formulation.Services;

import drugExpertSystem.formulation.Formulation;
import drugExpertSystem.formulation.Repository.FormulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Panupak on 10/12/2014.
 */
@Service
public class FormulationServiceImpl implements FormulationService {
    @Autowired
    FormulationRepository formulationRepository;

    @Override
    @Transactional
    public Formulation addFormulation(Formulation formulation) {
        try{
            formulationRepository.save(formulation);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return formulation;
    }

    @Override
    @Transactional
    public Formulation updateFormulation(Formulation formulation) {
        Formulation formulationInDb = formulationRepository.findOne(formulation.getId());
        formulationInDb.setExcipient(formulation.getExcipient());
        formulationRepository.save(formulationInDb);
        try{
            this.getFormulationById(formulation.getId());
        }catch (Exception e){
            return null;
        }
       return formulation;
    }

    @Override
    @Transactional
    public Formulation deleteFormulation(String id) {
        try{
            formulationRepository.delete(this.getFormulationById(id));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return this.getFormulationById(id);
    }

    @Override
    @Transactional
    public List<Formulation> getAllFormulation() {
        return formulationRepository.findAll();
    }

    @Override
    @Transactional
    public Formulation getFormulationById(String id) {
        return formulationRepository.findOne(id);
    }
}
