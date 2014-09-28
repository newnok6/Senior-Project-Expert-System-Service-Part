package drugExpertSystem.substance.Service.substanceService;

import drugExpertSystem.substance.Entity.SubstancePackage.Substance;

import java.util.List;

/**
 * Created by Panupak on 6/8/2014.
 */
public interface SubstanceService<T extends Substance> {
    public T addsubstance(T t);
    public T updateSubstance(T t);
    public T deleteSubstance(T t);
    public List<T> getAllSubstance();
    public T getSubstanceById(long id);
    public T getSubstanceByName(String name);

}
