package drugExpertSystem.excipient;

import drugExpertSystem.substance.Entity.SubstanceFunction.CompoundFunction;
import drugExpertSystem.substance.Entity.SubstancePackage.Substance;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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

    List<CompoundFunction> compoundFunctions;


    int quantity;


    float intensity;

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

    public List<CompoundFunction> getCompoundFunctions() {
        return compoundFunctions;
    }

    public void setCompoundFunctions(List<CompoundFunction> compoundFunctions) {
        this.compoundFunctions = compoundFunctions;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getIntensity() {
        return intensity;
    }

    public void setIntensity(float intensity) {
        this.intensity = intensity;
    }
}
