package drugExpertSystem.substance.Entity.substanceProperty;

import java.io.Serializable;

/**
 * Created by Panupak on 8/9/2014.
 */
public class SolubilityContrainer implements Serializable {
    private Solubility[] solubilities;

    public Solubility[] getSolubilities() {
        return solubilities;
    }

    public void setSolubilities(Solubility[] solubilities) {
        this.solubilities = solubilities;
    }
}
