package drugExpertSystem.Production;

import drugExpertSystem.formulation.Formulation;

import java.util.List;

/**
 * Created by Panupak on 10/12/2014.
 */
public interface ProductionService {
    public Production createProduction(Production production);
    public Production updateProduction(Production production);
    public Production removeProduction(String id);
    public List<Production> getAllProduction();
    public Production getProductionById(String id);
    public List<Formulation> getFormulationForProduction();
}
