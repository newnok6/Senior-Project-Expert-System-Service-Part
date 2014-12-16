package drugExpertSystem.ReformulationSetting;

import drugExpertSystem.InferenceProduction.InferenceProduction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Panupak on 11/10/2014.
 */
public class ReformulationSetting {
    InferenceProduction inferenceProduction;
    //String [][] similarlityWeight =new String[3][2];
    Map<String,String> fieldName = new HashMap<String,String>();
    Map<String,Double> similarlityWeight = new HashMap<String,Double>();

    public InferenceProduction getInferenceProduction() {
        return inferenceProduction;
    }

    public void setInferenceProduction(InferenceProduction inferenceProduction) {
        this.inferenceProduction = inferenceProduction;
    }
    public Map<String, String> getFieldName() {
        return fieldName;
    }

    public void setFieldName(Map<String, String> fieldName) {
        this.fieldName = fieldName;
    }

    public Map<String, Double> getSimilarlityWeight() {
        return similarlityWeight;
    }

    public void setSimilarlityWeight(Map<String, Double> similarlityWeight) {
        this.similarlityWeight = similarlityWeight;
    }
}
