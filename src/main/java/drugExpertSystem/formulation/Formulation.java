package drugExpertSystem.formulation;


import drugExpertSystem.excipient.Excipient;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Panupak on 8/19/2014.
 */
@Document
public class Formulation {
    @Id
    private String id;
    private String name;
    private String type;

    private List<Excipient> excipient;
    private Double totalWeight;

    @Transient
    private String source;

    public Formulation() {

    }

    public Formulation(Double totalWeight, List<Excipient> excipient, String source, String type, String name, String id) {
        this.totalWeight = totalWeight;
        this.excipient = excipient;
        this.source = source;
        this.type = type;
        this.name = name;
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Excipient> getExcipient() {
        return excipient;
    }

    public void setExcipient(List<Excipient> excipient) {
        this.excipient = excipient;
    }
}
