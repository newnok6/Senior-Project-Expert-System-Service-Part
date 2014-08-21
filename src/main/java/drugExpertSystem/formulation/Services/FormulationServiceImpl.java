package drugExpertSystem.formulation.Services;

import drugExpertSystem.formulation.Formulation;
import drugExpertSystem.formulation.Repository.FormulationRepository;
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


    @Override
    public Formulation addFormulation(Formulation formulation) {
        return null;
    }

    @Override
    public Formulation updateFormulation(Formulation formulation) {
        return null;
    }

    @Override
    public Formulation deleteFormulation(Formulation formulation) {
        return null;
    }

    @Override
    public List getAllFormulation() {
        return null;
    }

    @Override
    public Formulation getFormulationById(long id) {
        return null;
    }

    @Override
    public Formulation getFormulationByName(String name) {
        return null;
    }
}
