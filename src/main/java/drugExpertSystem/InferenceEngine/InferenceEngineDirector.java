package drugExpertSystem.InferenceEngine;

import drugExpertSystem.InferenceEngine.CaseBaseReasoningEngine.CasebaseReasoningEngine;
import drugExpertSystem.InferenceEngine.RuleBaseEngine.RulebaseEngine;
import drugExpertSystem.Production.Production;
import drugExpertSystem.Production.ProductionRepository;
import drugExpertSystem.ReformulateProduction.ReformulatedProduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Panupak on 10/7/2014.
 */
@Service
public class InferenceEngineDirector {

    @Autowired
    ProductionRepository productionRepository;



   public List<ReformulatedProduction> getReformulateResult(Production production){

       InferenceEngineCreator inferenceEngineCreator;


       ArrayList<ReformulatedProduction> reformulatedProductions = new ArrayList<>();

       //Reformulation by Rule Base //
        InferenceEngineCreator rulebaseEngine = new RulebaseEngine();
        rulebaseEngine.addReformulateData(production);
        rulebaseEngine.addBaseData(productionRepository.findAll());


       //Reformulation By Case Base Reasoning //
       InferenceEngineCreator casebaseReasoningEngine = new CasebaseReasoningEngine();
       casebaseReasoningEngine.addReformulateData(production);
       casebaseReasoningEngine.addBaseData(productionRepository.findAll());


       // Reformulated Production that reformulate by rulebase //
       ReformulatedProduction rulebaseProduction = new ReformulatedProduction();
       rulebaseProduction.setAccept(false);
       rulebaseProduction.setInferenceEngine("ruleBase");
       rulebaseProduction.setProduction(rulebaseEngine.getReformulateResult());

       // Reformulated Production that reformulate by case base reasoning //
       ReformulatedProduction casebaseProduction = new ReformulatedProduction();
       casebaseProduction.setAccept(false);
       casebaseProduction.setInferenceEngine("caseBase");
       casebaseProduction.setProduction(casebaseReasoningEngine.getReformulateResult());

       // Add reformulated production to the list //
       reformulatedProductions.add(rulebaseProduction);
       reformulatedProductions.add(casebaseProduction);

       return reformulatedProductions;
   }
}
