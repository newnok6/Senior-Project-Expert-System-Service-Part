package drugExpertSystem.substance.Entity.substanceProperty;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Solubility{
    @Id
    long id;

    String type;
    float maximumvalueproperty = 0f;
    float minimumvalueproperty =  0f;
    float value;

    public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value) {
        this.id = id;
        this.type = type;
        this.maximumvalueproperty = maximumvalueproperty;
        this.minimumvalueproperty = minimumvalueproperty;
        this.value = value;
    }

    public Solubility(long id, String type, float value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    public Solubility(String type, float maximumvalueproperty, float minimumvalueproperty, float value) {
        this.type = type;
        this.maximumvalueproperty = maximumvalueproperty;
        this.minimumvalueproperty = minimumvalueproperty;
        this.value = value;
    }

    public float getMaximumvalueproperty() {
        return this.maximumvalueproperty;
    }

    public void setMaximumvalueproperty(float maximumvalueproperty) {

        this.maximumvalueproperty = maximumvalueproperty;
    }

    public float getMinimumvalueproperty() {
        return this.minimumvalueproperty;
    }

    public void setMinimumvalueproperty(float minimumvalueproperty) {
        this.minimumvalueproperty = minimumvalueproperty;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}