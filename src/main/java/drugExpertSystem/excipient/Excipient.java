package drugExpertSystem.excipient;


import drugExpertSystem.substance.Substance;
import drugExpertSystem.substance.Entity.SubstanceFunction.SubstanceFunction;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

/**
 * Created by Panupak on 7/4/2014.
 */
@Document
public class Excipient {
    @Id
    private String id;

    //@DBRef
    private Substance substance;
    private List<SubstanceFunction> substanceFunctions;
    private String source;

    @Transient
    private SubstanceFunction substanceFunction;

    private double usedWeight;
    private double minWeight;
    private double maxWeight;


    public Excipient() {
    }

    public Excipient(double usedWeight, double minWeight, double maxWeight, String source, Substance substance) {
        this.usedWeight = usedWeight;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.source = source;
        this.substance = substance;
    }

    public Excipient(Substance substance, List<SubstanceFunction> substanceFunctions, String source, double usedWeight, double minWeight, double maxWeight) {
        this.substance = substance;
        this.substanceFunctions = substanceFunctions;
        this.source = source;
        this.usedWeight = usedWeight;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
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


    public List<SubstanceFunction> getSubstanceFunctions() {
        return substanceFunctions;
    }

    public void setSubstanceFunctions(List<SubstanceFunction> substanceFunctions) {
        this.substanceFunctions = substanceFunctions;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getUsedWeight() {
        return usedWeight;
    }

    public void setUsedWeight(double usedWeight) {
        this.usedWeight = usedWeight;
    }

    public double getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(double minWeight) {
        this.minWeight = minWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public SubstanceFunction getSubstanceFunction() {
        return substanceFunction;
    }

    public void setSubstanceFunction(SubstanceFunction substanceFunction) {
        this.substanceFunction = substanceFunction;
    }
}
