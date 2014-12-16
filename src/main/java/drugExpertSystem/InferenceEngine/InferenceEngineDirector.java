package drugExpertSystem.InferenceEngine;

import drugExpertSystem.InferenceEngine.CaseBaseReasoningEngine.CasebaseReasoningEngine;
import drugExpertSystem.InferenceEngine.HybridReasoningEngine.HybridReasoningEngine;
import drugExpertSystem.InferenceEngine.HybridReasoningEngine.InferenceEngineCreatorHybrid;
import drugExpertSystem.InferenceEngine.RuleBaseEngine.InferenceEngineCreatorForRuleBase;
import drugExpertSystem.InferenceEngine.RuleBaseEngine.RulebaseEngine;
import drugExpertSystem.Production.ProductionRepository;
import drugExpertSystem.ReformulatedProduction.ReformulatedProduction;
import drugExpertSystem.ReformulationSetting.ReformulationSetting;
import drugExpertSystem.excipient.ExcipientRepository;
import drugExpertSystem.formulation.Repository.FormulationRepository;
import drugExpertSystem.substance.repository.SubstanceRepository;
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
    SubstanceRepository substanceRepository;

    @Autowired
    ExcipientRepository excipientRepository;

    @Autowired
    FormulationRepository formulationRepository;

    @Autowired
    ProductionRepository productionRepository;


    public List<ReformulatedProduction> getReformulateResult(ReformulationSetting reformulationSetting){

        InferenceEngineCreator inferenceEngineCreator;


        ArrayList<ReformulatedProduction> reformulatedProductions = new ArrayList<>();

        // Reformulation by Rule Base //
        InferenceEngineCreatorForRuleBase rulebaseEngine = new RulebaseEngine();
        rulebaseEngine.addReformulateData(reformulationSetting);
        rulebaseEngine.setSubstanceFromDB(substanceRepository.findAll());
        rulebaseEngine.setExcipientFromDB(excipientRepository.findAll());
        rulebaseEngine.setFormulationFromDB(formulationRepository.findAll());
        rulebaseEngine.setProductionsFromDB(productionRepository.findAll());



        //Reformulation By Case Base Reasoning //
        InferenceEngineCreator casebaseReasoningEngine = new CasebaseReasoningEngine();
        casebaseReasoningEngine.addReformulateData(reformulationSetting);
        casebaseReasoningEngine.setProductionsFromDB(productionRepository.findAll());



        //Reformulated Production that reformulate by rulebase //
        ReformulatedProduction rulebaseProduction = new ReformulatedProduction();
        rulebaseProduction.setAccept(false);
        rulebaseProduction.setInferenceEngine("ruleBase");
        rulebaseProduction.setProduction(rulebaseEngine.getReformulateResult());



        // Add Rule Base Production to reformulated ProductionList//
        reformulatedProductions.add(rulebaseProduction);


        // Reformulated Production that reformulate by case base reasoning //
        ReformulatedProduction casebaseProduction = new ReformulatedProduction();
        casebaseProduction.setAccept(false);
        casebaseProduction.setInferenceEngine("caseBase");
        casebaseProduction.setProduction(casebaseReasoningEngine.getReformulateResult());


        // Add Case Base Production to reformulated Productionlist //
        reformulatedProductions.add(casebaseProduction);

        //Reformulation By Hybrid Reasoning , we created after case base reasoning reformulation.Because we use the formulation from case base production //
        InferenceEngineCreatorHybrid hybridReasoningEngine = new HybridReasoningEngine();
        hybridReasoningEngine.addReformulateData(reformulationSetting);
        hybridReasoningEngine.setSubstanceFromDB(substanceRepository.findAll());
        hybridReasoningEngine.setExcipientFromDB(excipientRepository.findAll());
        hybridReasoningEngine.setFormulationFromCaseBase(casebaseProduction.getProduction().getFormulation());
        hybridReasoningEngine.setProductionsFromDB(productionRepository.findAll());


        // Make the reformulation by using the hybrid reasoning engine
        ReformulatedProduction hybridProduction = new ReformulatedProduction();
        hybridProduction.setAccept(false);
        hybridProduction.setInferenceEngine("hybrid");
        hybridProduction.setProduction(hybridReasoningEngine.getReformulateResult());


        // Add Hybrid Production to reformulated Productionlist //
        reformulatedProductions.add(hybridProduction);





        // System.out.println(casebaseProduction.());
        //System.out.println(casebaseProduction.getProduction().getInstraction());



        return reformulatedProductions;
   }


}
