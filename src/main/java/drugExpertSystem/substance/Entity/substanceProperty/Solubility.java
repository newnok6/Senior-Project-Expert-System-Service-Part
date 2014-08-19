package drugExpertSystem.substance.Entity.substanceProperty;


public enum Solubility {

    PRACTICALLY("PracticallyInsoluble"),
    VERY("VerySoluble"),
    SLIGHTLY("SlightlySoluble"),
    SPARING("SparinglySoluble"),
    Soluble("Soluble"),
    VERYSLIGHTLY("VerySlightlySoluble"),
    FREELY("FreelySoluble");

    private String solubilityType;

    private Solubility(String solubilityType) {
        this.solubilityType = solubilityType;
    }

    public String getSolubilityType() {
        return solubilityType;
    }

    public void setSolubilityType(String solubilityType) {
        this.solubilityType = solubilityType;
    }
}
