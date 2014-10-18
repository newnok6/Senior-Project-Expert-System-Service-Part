package drugExpertSystem.Production.ActiveIngredientProperties;

import java.util.List;

/**
 * Created by Panupak on 10/18/2014.
 */

public class ActiveIngredient {
    String waterSolubility;
    List stability;
    double pka;
    double partitionCoefficient;
    String solidState;
    String hygroscopicity;
    String particleSize;
    String alcoholSolubility;
    String flowability;
    double density;
    String saltForm;
    double mocularWeight;
    String ionicity;

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

    public double getPka() {
        return pka;
    }

    public void setPka(double pka) {
        this.pka = pka;
    }

    public double getPartitionCoefficient() {
        return partitionCoefficient;
    }

    public void setPartitionCoefficient(double partitionCoefficient) {
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

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public String getSaltForm() {
        return saltForm;
    }

    public void setSaltForm(String saltForm) {
        this.saltForm = saltForm;
    }

    public double getMocularWeight() {
        return mocularWeight;
    }

    public void setMocularWeight(double mocularWeight) {
        this.mocularWeight = mocularWeight;
    }

    public String getIonicity() {
        return ionicity;
    }

    public void setIonicity(String ionicity) {
        this.ionicity = ionicity;
    }
}
