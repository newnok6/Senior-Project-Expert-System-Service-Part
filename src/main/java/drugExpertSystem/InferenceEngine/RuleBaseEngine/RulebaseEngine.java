package drugExpertSystem.InferenceEngine.RuleBaseEngine;

import drugExpertSystem.InferenceEngine.InferenceEngineCreator;
import drugExpertSystem.Production.Production;
import jess.JessException;
import jess.Rete;

import java.util.List;

/**
 * Created by Panupak on 10/7/2014.
 */
public class RulebaseEngine implements InferenceEngineCreator<Production> {

     Production reformulateproduction;
     List<Production> baseProduction;
     Rete jessEngine;

    @Override
    public void addBaseData(List<Production> productionList) {
          this.baseProduction = productionList;
    }

    @Override
    public void addReformulateData(Production production) {
          this.reformulateproduction = production;
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
        return reformulateproduction;
    }



}
