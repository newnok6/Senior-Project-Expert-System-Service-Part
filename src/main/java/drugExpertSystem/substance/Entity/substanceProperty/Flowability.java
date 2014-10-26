package drugExpertSystem.substance.Entity.substanceProperty;

/**
 * Created by Panupak on 8/9/2014.
 */
public enum Flowability {
    A("A");

    private String flowabilityType;

    Flowability(String flowabilityType) {
        this.flowabilityType = flowabilityType;
    }

    public String getFlowabilityType() {
        return flowabilityType;
    }
}
