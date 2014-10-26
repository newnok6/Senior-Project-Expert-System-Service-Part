package drugExpertSystem.substance.Entity.substanceProperty;


public enum Solubility {

<<<<<<< HEAD
@Document
public class Solubility {
    @Id
    long id;

    String type;

    float value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
=======
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
>>>>>>> New_Drug_Expert_System_beta_version
