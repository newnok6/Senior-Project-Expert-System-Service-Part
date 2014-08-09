package drugExpertSystem.substance.Entity.substanceProperty;

/**
 * Created by Panupak on 8/9/2014.
 */
public enum Ionicity {
    A("A");

    private String ionicitytype;

    Ionicity(String ionicitytype) {
        this.ionicitytype = ionicitytype;
    }

    public String getIonicitytype() {
        return ionicitytype;
    }
}
