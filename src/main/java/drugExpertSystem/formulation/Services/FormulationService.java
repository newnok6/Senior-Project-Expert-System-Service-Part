package drugExpertSystem.formulation.Services;

import drugExpertSystem.formulation.Formulation;


import java.util.List;

/**
 * Created by Panupak on 8/21/2014.
 */
public interface FormulationService <T extends Object> {
    public T addFormulation(T t);
    public T updateFormulation(T t);
    public T deleteFormulation(T t);
    public List<T> getAllFormulation();
    public T getFormulation(String id);
}
