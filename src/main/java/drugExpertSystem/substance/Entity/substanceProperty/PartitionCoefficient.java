package drugExpertSystem.substance.Entity.substanceProperty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PartitionCoefficient {
    @Id
    long id;
    float pcValueProperty;
    String type;

    public float getPcValueProperty() {
        return pcValueProperty;
    }

    public void setPcValueProperty(float pcValueProperty) {
        this.pcValueProperty = pcValueProperty;
    }

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
}