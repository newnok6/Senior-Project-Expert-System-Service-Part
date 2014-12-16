package drugExpertSystem.InferenceProduction;

import drugExpertSystem.Production.DFProperties.DFProperty;
import drugExpertSystem.substance.Substance;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by Panupak on 11/22/2014.
 */
public class InferenceProduction {
    @Id
    private String id;

    //The formulation must be set as Substance Name //
    private Substance substance;
    private double amountOfStength;
    //private DFProperty dfProperty;
    private double totalWeight;
    private int disintegrationTime;
    private double friability;
    private List<Double> dissolutionProfile;

    public InferenceProduction() {

    }

    public InferenceProduction(Substance substance, double amountOfStength, double totalWeight, int disintegrationTime, double friability, List<Double> dissolutionProfile) {
        this.substance = substance;
        this.amountOfStength = amountOfStength;
        this.totalWeight = totalWeight;
        this.disintegrationTime = disintegrationTime;
        this.friability = friability;
        this.dissolutionProfile = dissolutionProfile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Substance getSubstance() {
        return substance;
    }

    public void setSubstance(Substance substance) {
        this.substance = substance;
    }



    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public int getDisintegrationTime() {
        return disintegrationTime;
    }

    public void setDisintegrationTime(int disintegrationTime) {
        this.disintegrationTime = disintegrationTime;
    }

    public double getFriability() {
        return friability;
    }

    public void setFriability(double friability) {
        this.friability = friability;
    }

    public List<Double> getDissolutionProfile() {
        return dissolutionProfile;
    }

    public void setDissolutionProfile(List<Double> dissolutionProfile) {
        this.dissolutionProfile = dissolutionProfile;
    }

    public double getAmountOfStength() {
        return amountOfStength;
    }

    public void setAmountOfStength(double amountOfStength) {
        this.amountOfStength = amountOfStength;
    }
}
