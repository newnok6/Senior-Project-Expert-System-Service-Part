package drugExpertSystem.formulation.Services;

import drugExpertSystem.formulation.Formulation;


import java.util.List;

/**
 * Created by Panupak on 8/21/2014.
 */
public interface FormulationService{
    public Formulation addFormulation(Formulation t);
    public Formulation updateFormulation(Formulation t);
    public Formulation deleteFormulation(String id);
    public List<Formulation> getAllFormulation();
    public Formulation getFormulationById(String id);
}
