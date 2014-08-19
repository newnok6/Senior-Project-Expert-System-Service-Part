package drugExpertSystem.substance.Entity.SubstancePackage;


import drugExpertSystem.substance.Entity.substanceProperty.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
public class Substance{
    @Id
    long id;
    String name;
    String watersolubility;
    List stability;
    float pka;
    float partitionCoefficient;
    String solidstate;
    Hygroscopicity hygroscopicity;
    ParticleSize particleSize;
    Solubility alcoholSolubility;
    Flowability flowability;
    float density;
    String saltForm;
    float mocularWeight;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWatersolubility() {
        return watersolubility;
    }

    public void setWatersolubility(String watersolubility) {
        this.watersolubility = watersolubility;
    }

    public List getStability() {
        return stability;
    }

    public void setStability(List stability) {
        this.stability = stability;
    }

    public float getPka() {
        return pka;
    }

    public void setPka(float pka) {
        this.pka = pka;
    }

    public float getPartitionCoefficient() {
        return partitionCoefficient;
    }

    public void setPartitionCoefficient(float partitionCoefficient) {
        this.partitionCoefficient = partitionCoefficient;
    }

    public String getSolidstate() {
        return solidstate;
    }

    public void setSolidstate(String solidstate) {
        this.solidstate = solidstate;
    }

    public Hygroscopicity getHygroscopicity() {
        return hygroscopicity;
    }

    public void setHygroscopicity(Hygroscopicity hygroscopicity) {
        this.hygroscopicity = hygroscopicity;
    }

    public ParticleSize getParticleSize() {
        return particleSize;
    }

    public void setParticleSize(ParticleSize particleSize) {
        this.particleSize = particleSize;
    }

    public Solubility getAlcoholSolubility() {
        return alcoholSolubility;
    }

    public void setAlcoholSolubility(Solubility alcoholSolubility) {
        this.alcoholSolubility = alcoholSolubility;
    }

    public Flowability getFlowability() {
        return flowability;
    }

    public void setFlowability(Flowability flowability) {
        this.flowability = flowability;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public String getSaltForm() {
        return saltForm;
    }

    public void setSaltForm(String saltForm) {
        this.saltForm = saltForm;
    }

    public float getMocularWeight() {
        return mocularWeight;
    }

    public void setMocularWeight(float mocularWeight) {
        this.mocularWeight = mocularWeight;
    }
}