package drugExpertSystem.Model;


import drugExpertSystem.substance.Entity.SubstanceFunction.SubstanceFunction;
import drugExpertSystem.Model.Substance;
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
    String id;

    @DBRef
    Substance substance;
    List<SubstanceFunction> substanceFunctions;
    double usedWeight;



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

    public double getUsedWeight() {
        return usedWeight;
    }

    public void setUsedWeight(double usedWeight) {
        this.usedWeight = usedWeight;
    }
}
