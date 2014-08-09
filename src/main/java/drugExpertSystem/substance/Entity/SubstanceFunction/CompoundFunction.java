package drugExpertSystem.substance.Entity.SubstanceFunction;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CompoundFunction{
    @Id
    long id;
    String type;
    float maxconcentrationproperty;
    float minconcentrationproperty;

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

    public float getMaxconcentrationproperty() {
        return this.maxconcentrationproperty;
    }

    public void setMaxconcentrationproperty(float maxconcentrationproperty) {
        this.maxconcentrationproperty = maxconcentrationproperty;
    }

    public float getMinconcentrationproperty() {
        return this.minconcentrationproperty;
    }

    public void setMinconcentrationproperty(float minconcentrationproperty) {
        this.minconcentrationproperty = minconcentrationproperty;
    }



}