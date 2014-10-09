package drugExpertSystem.InferenceEngine.CaseBaseReasoningEngine;

import drugExpertSystem.InferenceEngine.InferenceEngineCreator;
import drugExpertSystem.Production.DFProperties.DFProperty;
import drugExpertSystem.Production.Production;
import drugExpertSystem.formulation.Repository.SolutionFormulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Panupak on 10/7/2014.
 */

public class CasebaseReasoningEngine implements InferenceEngineCreator<Production> {
    Production reformulateproduction;
    List<Production> baseProduction;

    @Autowired
    SolutionFormulationRepository solutionFormulationRepository;
    public  Production reformuateResult;
    @Override
    public void addBaseData(List<Production> t) {
        this.baseProduction = t;
    }

    @Override
    public void addReformulateData(Production production) {
        this.reformulateproduction = production;
    }

    @Override
    public Production getReformulateResult() {
        DFProperty dfProperty = new DFProperty();
        dfProperty.setDisgradationtime(50);
        dfProperty.setTotalweight(14);
        dfProperty.setHardness(90);
        dfProperty.setDissolutionProfile(reformulateproduction.getDfProperty().getDissolutionProfile());
        reformulateproduction.setDfProperty(dfProperty);
        reformuateResult = reformulateproduction;
        return reformuateResult ;
    }
}
