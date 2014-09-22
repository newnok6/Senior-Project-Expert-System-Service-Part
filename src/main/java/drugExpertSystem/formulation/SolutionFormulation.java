package drugExpertSystem.formulation;

import drugExpertSystem.excipient.Excipient;

import java.util.List;

/**
 * Created by Panupak on 8/21/2014.
 */
public class SolutionFormulation extends Formulation {
    List<Excipient> solvent	 ;

    public List<Excipient> getSolvent() {
        return solvent;
    }

    public void setSolvent(List<Excipient> solvent) {
        this.solvent = solvent;
    }
}
