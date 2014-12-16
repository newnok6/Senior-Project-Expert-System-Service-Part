package drugExpertSystem.InferenceEngine.RuleBaseEngine;

import drugExpertSystem.InferenceEngine.InferenceEngineCreator;
import drugExpertSystem.Production.Production;
import drugExpertSystem.excipient.Excipient;
import drugExpertSystem.substance.Substance;
import drugExpertSystem.formulation.Formulation;

import java.util.List;

/**
 * Created by Panupak on 11/22/2014.
 */
public interface InferenceEngineCreatorForRuleBase extends InferenceEngineCreator {
    public void setSubstanceFromDB(List<Substance> substanceList);
    public void setExcipientFromDB(List<Excipient> excipientList);
    public void setFormulationFromDB(List<Formulation> formulationList);

}
