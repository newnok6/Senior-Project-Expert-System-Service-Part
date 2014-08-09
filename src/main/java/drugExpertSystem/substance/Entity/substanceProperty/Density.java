package drugExpertSystem.substance.Entity.substanceProperty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Density {
    @Id
    long id;
    String type;

    @Field("densityValue")
    float densityValue;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getDensityValue() {
        return densityValue;
    }

    public void setDensityValue(float densityValue) {
        this.densityValue = densityValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}