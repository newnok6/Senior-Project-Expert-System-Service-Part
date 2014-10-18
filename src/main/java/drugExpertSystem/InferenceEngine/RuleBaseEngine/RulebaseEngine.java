package drugExpertSystem.InferenceEngine.RuleBaseEngine;

import drugExpertSystem.InferenceEngine.InferenceEngineCreator;
import drugExpertSystem.Production.DFProperties.DFProperty;
import drugExpertSystem.Production.Production;
import jess.JessException;
import jess.Rete;

import java.util.List;

/**
 * Created by Panupak on 10/7/2014.
 */
public class RulebaseEngine implements InferenceEngineCreator{

     private Production reformulateproduction;
     private List<Production> baseProduction;
     private Rete jessEngine;

    @Override
    public void addBaseData(List<Production> productionList) {

        baseProduction = productionList;
    }

    @Override
    public void addReformulateData(Production production) {

        reformulateproduction = production;
    }

    @Override
    public Production getReformulateResult(){
        jessEngine = new Rete();
        try{
            jessEngine.reset();
            jessEngine.addAll(this.baseProduction);
        }catch (JessException ex){
            ex.getExecutionContext();
        }
        Production production = new Production();
        production.setFormulationName(reformulateproduction.getFormulationName());
        production.setFormulationWeight(reformulateproduction.getFormulationWeight());
        DFProperty dfProperty = new DFProperty();
        dfProperty.setDisgradationtime(50);
        dfProperty.setTotalweight(14);
        dfProperty.setHardness(90);
        dfProperty.setDissolutionProfile(reformulateproduction.getDfProperty().getDissolutionProfile());
        production.setDfProperty(dfProperty);
        return production;
    }



}
