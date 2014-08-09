package drugExpertSystem.substance.Entity.SubstancePackage;


import drugExpertSystem.substance.Entity.substanceProperty.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class Substance{
    @Id
    long id;
    String name;
    @DBRef
    Solubility watersolubilityproperty;

    Stability stabilityproperty ;
    @DBRef
    Pka dissolutionproperty;
    @DBRef
    PartitionCoefficient partitioncoefficientproperty;
    @DBRef
    Solidstate physicalformproperty;
    @DBRef
    Hygroscopicity hygroscopicityproperty;
    @DBRef
    ParticleSize particleproperty;
    @DBRef
    Solubility alcoholsolubilityproperty;
    @DBRef
    Flowability flowabilityproperty;

    @DBRef
    Density powderdensityproperty;

    SaltForm saltproperty;

    float weightproperty;
    String lonicity;

    public Solubility getWatersolubilityproperty() {
        return watersolubilityproperty;
    }

    public void setWatersolubilityproperty(Solubility watersolubilityproperty) {
        this.watersolubilityproperty = watersolubilityproperty;
    }

    public Stability getStabilityproperty() {
        return stabilityproperty;
    }

    public void setStabilityproperty(Stability stabilityproperty) {
        this.stabilityproperty = stabilityproperty;
    }

    public Pka getDissolutionproperty() {
        return dissolutionproperty;
    }

    public void setDissolutionproperty(Pka dissolutionproperty) {
        this.dissolutionproperty = dissolutionproperty;
    }

    public PartitionCoefficient getPartitioncoefficientproperty() {
        return partitioncoefficientproperty;
    }

    public void setPartitioncoefficientproperty(PartitionCoefficient partitioncoefficientproperty) {
        this.partitioncoefficientproperty = partitioncoefficientproperty;
    }

    public Solidstate getPhysicalformproperty() {
        return physicalformproperty;
    }

    public void setPhysicalformproperty(Solidstate physicalformproperty) {
        this.physicalformproperty = physicalformproperty;
    }

    public Hygroscopicity getHygroscopicityproperty() {
        return hygroscopicityproperty;
    }

    public void setHygroscopicityproperty(Hygroscopicity hygroscopicityproperty) {
        this.hygroscopicityproperty = hygroscopicityproperty;
    }

    public ParticleSize getParticleproperty() {
        return particleproperty;
    }

    public void setParticleproperty(ParticleSize particleproperty) {
        this.particleproperty = particleproperty;
    }

    public Solubility getAlcoholsolubilityproperty() {
        return alcoholsolubilityproperty;
    }

    public void setAlcoholsolubilityproperty(Solubility alcoholsolubilityproperty) {
        this.alcoholsolubilityproperty = alcoholsolubilityproperty;
    }

    public Flowability getFlowabilityproperty() {
        return flowabilityproperty;
    }

    public void setFlowabilityproperty(Flowability flowabilityproperty) {
        this.flowabilityproperty = flowabilityproperty;
    }


    public Density getPowderdensityproperty() {
        return powderdensityproperty;
    }

    public void setPowderdensityproperty(Density powderdensityproperty) {
        this.powderdensityproperty = powderdensityproperty;
    }

    public SaltForm getSaltproperty() {
        return saltproperty;
    }

    public void setSaltproperty(SaltForm saltproperty) {
        this.saltproperty = saltproperty;
    }

    public float getWeightproperty() {
        return weightproperty;
    }

    public void setWeightproperty(float weightproperty) {
        this.weightproperty = weightproperty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLonicity() {
        return lonicity;
    }

    public void setLonicity(String lonicity) {
        this.lonicity = lonicity;
    }
}