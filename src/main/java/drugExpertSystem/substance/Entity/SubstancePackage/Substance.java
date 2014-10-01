package drugExpertSystem.substance.Entity.SubstancePackage;


import drugExpertSystem.substance.Entity.substanceProperty.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
public class Substance{


    @Id
    String id;
    String name;
    String waterSolubility;
    List stability;
    float pka;
    float partitionCoefficient;
    String solidState;
    String hygroscopicity;
    String particleSize;
    String alcoholSolubility;
    String flowability;
    float density;
    String saltForm;
    float mocularWeight;
    String ionicity;


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

    public String getWaterSolubility() {
        return waterSolubility;
    }

    public void setWaterSolubility(String waterSolubility) {
        this.waterSolubility = waterSolubility;
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

    public String getSolidState() {
        return solidState;
    }

    public void setSolidState(String solidState) {
        this.solidState = solidState;
    }

    public String getHygroscopicity() {
        return hygroscopicity;
    }

    public void setHygroscopicity(String hygroscopicity) {
        this.hygroscopicity = hygroscopicity;
    }

    public String getParticleSize() {
        return particleSize;
    }

    public void setParticleSize(String particleSize) {
        this.particleSize = particleSize;
    }

    public String getAlcoholSolubility() {
        return alcoholSolubility;
    }

    public void setAlcoholSolubility(String alcoholSolubility) {
        this.alcoholSolubility = alcoholSolubility;
    }

    public String getFlowability() {
        return flowability;
    }

    public void setFlowability(String flowability) {
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

    public String getIonicity() {
        return ionicity;
    }

    public void setIonicity(String ionicity) {
        this.ionicity = ionicity;
    }
}