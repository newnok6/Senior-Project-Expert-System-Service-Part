package drugExpertSystem.substance.Entity.substanceProperty;

/**
 * Created by Panupak on 8/9/2014.
 */
public enum Solubility {

    PRACTICALLY("PracticallyInsoluble"),
    VERY("VerySoluble"),
    SLIGHTLY("SlightlySoluble"),
    SPARING("SparinglySoluble"),
    Soluble("Soluble"),
    VERYSLIGHTLY("VerySlightlySoluble"),
    FREELY("FreelySoluble");

    private String solubilityType;

    Solubility(String solubilityType) {
        this.solubilityType = solubilityType;
    }

    public String getSolubilityType() {
        return solubilityType;
    }
}
