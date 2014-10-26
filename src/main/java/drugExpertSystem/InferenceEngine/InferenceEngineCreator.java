package drugExpertSystem.InferenceEngine;

import drugExpertSystem.Production.Production;
import jess.JessException;

import java.util.List;

/**
 * Created by Panupak on 10/7/2014.
 */
public interface InferenceEngineCreator{
    public void addBaseData(List<Production> productions);
    public void addReformulateData(Production production);
    public Production getReformulateResult() ;


}
