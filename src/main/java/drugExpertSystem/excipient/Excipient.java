package drugExpertSystem.excipient;


import drugExpertSystem.substance.Entity.SubstanceFunction.SubstanceFunction;
import drugExpertSystem.substance.Entity.SubstancePackage.Substance;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

/**
 * Created by Panupak on 7/4/2014.
 */
@Document
public class Excipient {
    @Id
    long id;

    @DBRef
    Substance substance;

    List<SubstanceFunction> substanceFunctions;



    float minWeight;
    float maxWeight;
    float usedWeight;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Substance getSubstance() {
        return substance;
    }

    public void setSubstance(Substance substance) {
        this.substance = substance;
    }

    public float getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(float minWeight) {
        this.minWeight = minWeight;
    }

    public float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
    }

    public float getUsedWeight() {
        return usedWeight;
    }

    public void setUsedWeight(float usedWeight) {
        this.usedWeight = usedWeight;
    }

    public List<SubstanceFunction> getSubstanceFunctions() {
        return substanceFunctions;
    }

    public void setSubstanceFunctions(List<SubstanceFunction> substanceFunctions) {
        this.substanceFunctions = substanceFunctions;
    }
}
