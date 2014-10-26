package drugExpertSystem.substance.Entity.substanceProperty;

/**
 * Created by Panupak on 8/9/2014.
 */
public enum Hygroscopicity {
    A("A");

    private String hygroscopicityType;

    Hygroscopicity(String hygroscopicityType) {
        this.hygroscopicityType = hygroscopicityType;
    }

    public String getHygroscopicityType() {
        return hygroscopicityType;
    }
}
