package jcolibri.examples.genericDrug;

import jcolibri.cbrcore.Attribute;

/**
 * Created by COMPAQ on 7/11/2557.
 */
public class GenericDescription implements jcolibri.cbrcore.CaseComponent{
    String  caseId;
    String name;
    Double userWeight;
    Integer disgrationtime;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(Double userWeight) {
        this.userWeight = userWeight;
    }

    public Integer getDisgrationtime() {
        return disgrationtime;
    }

    public void setDisgrationtime(Integer disgrationtime) {
        this.disgrationtime = disgrationtime;
    }

    @Override
    public String toString() {
        return "GenericDescription{" +
                "caseId='" + caseId + '\'' +
                ", name='" + name + '\'' +
                ", userWeight=" + userWeight +
                ", disgrationtime=" + disgrationtime +
                '}';
    }

    @Override
    public Attribute getIdAttribute() {
        return new Attribute("caseId", this.getClass());
    }
}
