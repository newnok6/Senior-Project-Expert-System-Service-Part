package drugExpertSystem.excipient.services;

import drugExpertSystem.Model.Excipient;
import drugExpertSystem.Model.Substance;
import drugExpertSystem.substance.Entity.SubstanceFunction.SubstanceFunction;

import java.util.List;

/**
 * Created by Panupak on 9/24/2014.
 */
public interface ExcipientService<T extends Excipient> {
    public T addExcipient(T t);
    public T updateExcipient(T t);
    public T deleteExcipient(T t);
    public List<T> getAllExcipient();
    public T getExcipientById(String id);
    public void setSubstanceFunction(SubstanceFunction substanceFunction);
    public List<SubstanceFunction> getSubstaneFunction();
    public List<Substance> getSubstanceForExcipient();

}
