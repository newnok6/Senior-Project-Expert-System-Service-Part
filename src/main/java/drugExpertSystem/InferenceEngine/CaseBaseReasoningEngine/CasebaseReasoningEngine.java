package drugExpertSystem.InferenceEngine.CaseBaseReasoningEngine;

import drugExpertSystem.InferenceEngine.InferenceEngineCreator;
import drugExpertSystem.Production.DFProperties.DFProperty;
import drugExpertSystem.Production.Production;

import drugExpertSystem.formulation.Repository.FormulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Panupak on 10/7/2014.
 */

public class CasebaseReasoningEngine implements InferenceEngineCreator{
    private Production caseBaseproduction;
    private List<Production> baseProduction;

    @Autowired
    FormulationRepository formulationRepository;


    @Override
    public void addBaseData(List<Production> productions) {

        baseProduction = productions;
    }

    @Override
    public void addReformulateData(Production production) {

        caseBaseproduction = production;
    }

    @Override
    public Production getReformulateResult() {

       Production production = new Production();
       production.setFormulation(caseBaseproduction.getFormulation());
       production.setFormulationWeight(caseBaseproduction.getFormulationWeight());
       DFProperty dfProperty = new DFProperty();
       dfProperty.setDisgradationtime(70);
       dfProperty.setTotalweight(14);
       dfProperty.setHardness(90);
       dfProperty.setDissolutionProfile(caseBaseproduction.getDfProperty().getDissolutionProfile());
       production.setDfProperty(dfProperty);

       return production;
    }
}
