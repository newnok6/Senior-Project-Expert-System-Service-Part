package drugExpertSystem.InferenceEngine;

import drugExpertSystem.InferenceEngine.CaseBaseReasoningEngine.CasebaseReasoningEngine;
import drugExpertSystem.InferenceEngine.RuleBaseEngine.RulebaseEngine;
import drugExpertSystem.Production.Production;
import drugExpertSystem.Production.ProductionRepository;
import drugExpertSystem.ReformulateProduction.ReformulateProduction;
import jess.JessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Panupak on 10/7/2014.
 */
@Service
public class InferenceEngineDirector {

    @Autowired
    ProductionRepository productionRepository;



  @Transactional
   public List<ReformulateProduction> getReformulateProduction(ReformulateProduction reformulateProduction) throws JessException {
       InferenceEngineCreator inferenceEngineCreator;

       List<ReformulateProduction> reformulateResult = new ArrayList<>();

       inferenceEngineCreator = new RulebaseEngine();
       inferenceEngineCreator.addReformulateData(reformulateProduction.getProduction());
       inferenceEngineCreator.addBaseData(productionRepository.findAll());

       //Reformulation By Rule Base //
       ReformulateProduction rulebaseSection = new ReformulateProduction();
       rulebaseSection.setInferenceEngine("ruleBase");
       rulebaseSection.setProduction((Production) inferenceEngineCreator.getReformulateResult());
       rulebaseSection.setUser(reformulateProduction.getUser());
       reformulateResult.add(rulebaseSection);


       //Reformulation By Case Base Reasoning //
       inferenceEngineCreator = new CasebaseReasoningEngine();
       inferenceEngineCreator.addReformulateData(reformulateProduction.getProduction());
       inferenceEngineCreator.addBaseData(productionRepository.findAll());
       ReformulateProduction caseBaseSection = new ReformulateProduction();
       caseBaseSection.setInferenceEngine("caseBase");
       caseBaseSection.setProduction((Production) inferenceEngineCreator.getReformulateResult());
       rulebaseSection.setUser(reformulateProduction.getUser());
       reformulateResult.add(caseBaseSection);


       return reformulateResult;
   }
}
