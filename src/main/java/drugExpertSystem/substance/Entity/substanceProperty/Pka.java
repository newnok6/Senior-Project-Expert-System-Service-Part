package drugExpertSystem.substance.Entity.substanceProperty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Pka {
    @Id
    long id;
    String type;
    @Field("maxinumValue")
    float maxValue;
    @Field("mininumValue")
    float minValue;
    @Field("pkaPropertyValue")
    float pkaValue;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }

    public float getMinValue() {
        return minValue;
    }

    public void setMinValue(float minValue) {
        this.minValue = minValue;
    }

    public float getPkaValue() {
        return pkaValue;
    }

    public void setPkaValue(float pkaValue) {
        this.pkaValue = pkaValue;
    }
}