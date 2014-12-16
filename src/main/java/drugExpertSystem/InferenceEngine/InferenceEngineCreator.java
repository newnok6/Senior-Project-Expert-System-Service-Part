package drugExpertSystem.InferenceEngine;

import drugExpertSystem.Production.Production;
import drugExpertSystem.ReformulationSetting.ReformulationSetting;
import jess.JessException;

import java.util.List;

/**
 * Created by Panupak on 10/7/2014.
 */
public interface InferenceEngineCreator{
    public List<Production> setProductionsFromDB(List<Production> productions);
    public ReformulationSetting addReformulateData(ReformulationSetting reformulationSetting);
    public Production getReformulateResult();


}
