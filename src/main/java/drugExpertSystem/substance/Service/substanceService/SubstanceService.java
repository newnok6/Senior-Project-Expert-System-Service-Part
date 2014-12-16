package drugExpertSystem.substance.Service.substanceService;



import drugExpertSystem.substance.Substance;

import java.util.List;

/**
 * Created by Panupak on 6/8/2014.
 */
public interface SubstanceService {
    public Substance addsubstance(Substance substance);
    public Substance updateSubstance(Substance substance);
    public Substance deleteSubstance(Substance substance);
    public List<Substance> getAllSubstance();
    public Substance getSubstanceById(String id);


}
