package drugExpertSystem.excipient.services;

import drugExpertSystem.Model.Excipient;
import drugExpertSystem.Model.Substance;
import drugExpertSystem.substance.Entity.SubstanceFunction.SubstanceFunction;

import java.util.List;

/**
 * Created by Panupak on 9/24/2014.
 */
public interface ExcipientService {
    public Excipient addExcipient(Excipient t);
    public Excipient updateExcipient(Excipient excipient);
    public Excipient deleteExcipient(Excipient excipient);
    public List<Excipient> getAllExcipient();
    public Excipient getExcipientById(String id);
    public void setSubstanceFunction(SubstanceFunction substanceFunction);
    public List<SubstanceFunction> getSubstaneFunction();
    //public List<Substance> getSubstanceForExcipient();

}
