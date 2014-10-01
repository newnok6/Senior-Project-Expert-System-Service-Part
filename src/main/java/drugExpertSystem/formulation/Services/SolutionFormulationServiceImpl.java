package drugExpertSystem.formulation.Services;

import drugExpertSystem.formulation.Repository.SolutionFormulationRepository;
import drugExpertSystem.formulation.SolutionFormulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Panupak on 10/1/2014.
 */
@Service
public class SolutionFormulationServiceImpl implements SolutionFormulationService {
    @Autowired
    SolutionFormulationRepository solutionFormulationRepository;

    @Override
    @Transactional
    public SolutionFormulation addFormulation(SolutionFormulation solutionFormulation) {
        solutionFormulationRepository.save(solutionFormulation);
        try{
            this.getFormulation(solutionFormulation.getId());
        }catch (Exception e){
            return null;
        }

        return solutionFormulation;
    }

    @Override
    @Transactional
    public SolutionFormulation updateFormulation(SolutionFormulation solutionFormulation) {
        SolutionFormulation tabletFormulationInDb = solutionFormulationRepository.findOne(solutionFormulation.getId());
        tabletFormulationInDb.setApi(solutionFormulation.getApi());
        solutionFormulationRepository.save(tabletFormulationInDb);
        try{
            this.getFormulation(solutionFormulation.getId());
        }catch (Exception e){
            return null;
        }

        return solutionFormulation;
    }

    @Override
    @Transactional
    public SolutionFormulation deleteFormulation(SolutionFormulation solutionFormulation) {
        solutionFormulationRepository.delete(solutionFormulation);
        try{
            this.getFormulation(solutionFormulation.getId());
        }catch (Exception e){
            return null;
        }

        return solutionFormulation;
    }

    @Override
    @Transactional
    public List<SolutionFormulation> getAllFormulation() {
        return solutionFormulationRepository.findAll();
    }

    @Override
    @Transactional
    public SolutionFormulation getFormulation(String id) {
        return solutionFormulationRepository.findOne(id);
    }
}
