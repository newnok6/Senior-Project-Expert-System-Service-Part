package drugExpertSystem.substance.Entity.substanceProperty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ParticleSize {
    @Id
    long id;
    String type;
    float maximumparticlesize;
    float minimalparticlesize;
    float valueProperty;

    public float getMaximumparticlesize() {
        return this.maximumparticlesize;
    }

    public void setMaximumparticlesize(float maximumparticlesize) {

        this.maximumparticlesize = maximumparticlesize;
    }

    public float getMinimalparticlesize() {
        return this.minimalparticlesize;
    }

    public void setMinimalparticlesize(float minimalparticlesize) {

        this.minimalparticlesize = minimalparticlesize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getValueProperty() {
        return valueProperty;
    }

    public void setValueProperty(float valueProperty) {
        this.valueProperty = valueProperty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}