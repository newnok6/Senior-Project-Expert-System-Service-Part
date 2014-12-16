package drugExpertSystem.InferenceEngine.HybridReasoningEngine;

import drugExpertSystem.InferenceEngine.InferenceEngineCreator;
import drugExpertSystem.excipient.Excipient;
import drugExpertSystem.formulation.Formulation;
import drugExpertSystem.substance.Substance;

import java.util.List;

/**
 * Created by Panupak on 12/15/2014.
 */
public interface InferenceEngineCreatorHybrid extends InferenceEngineCreator {
    public void setSubstanceFromDB(List<Substance> substanceList);
    public void setExcipientFromDB(List<Excipient> excipientList);
    public void setFormulationFromCaseBase(Formulation formulation);
}
