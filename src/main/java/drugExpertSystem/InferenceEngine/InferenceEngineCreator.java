package drugExpertSystem.InferenceEngine;

import drugExpertSystem.Production.Production;
import jess.JessException;

import java.util.List;

/**
 * Created by Panupak on 10/7/2014.
 */
public interface InferenceEngineCreator <T extends Object> {
    public void addBaseData(List<T> t);
    public void addReformulateData(T t);
    public T getReformulateResult() throws JessException;


}
