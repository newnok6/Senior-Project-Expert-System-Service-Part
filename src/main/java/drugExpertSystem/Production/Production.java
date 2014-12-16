package drugExpertSystem.Production;


import drugExpertSystem.Production.ActiveIngredientProperties.ActiveIngredient;
import
        drugExpertSystem.Production.DFProperties.DFProperty;
import drugExpertSystem.Production.Process.PharmaceuticalProcess;
import drugExpertSystem.Production.QualityControl.QualityControl;
import drugExpertSystem.formulation.Formulation;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Panupak on 8/21/2014.
 */
@Document
public class Production  {

    @Id
    private String id;
   // private String source;
    private PharmaceuticalProcess pharmaceuticalProcess;
    private Formulation formulation;
   // private ActiveIngredient activeIngredient;
    private double totalWeight;
    private int distegretionTime;
    private double friability;
    private List<Double> dissolutionProfile;
    private String type;
    private String formulationName;
    private DFProperty dfProperty;
    @TextIndexed
    private String instraction;

    public Production() {
    }

    public Production(PharmaceuticalProcess pharmaceuticalProcess, Formulation formulation, double totalWeight, int distegretionTime, List<Double> dissolutionProfile, double friability, String type, String formulationName, String instraction) {
        this.pharmaceuticalProcess = pharmaceuticalProcess;
        this.formulation = formulation;
        this.totalWeight = totalWeight;
        this.distegretionTime = distegretionTime;
        this.dissolutionProfile = dissolutionProfile;
        this.friability = friability;
        this.type = type;
        this.formulationName = formulationName;
        this.instraction = instraction;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PharmaceuticalProcess getPharmaceuticalProcess() {
        return pharmaceuticalProcess;
    }

    public void setPharmaceuticalProcess(PharmaceuticalProcess pharmaceuticalProcess) {
        this.pharmaceuticalProcess = pharmaceuticalProcess;
    }

    public Formulation getFormulation() {
        return formulation;
    }

    public void setFormulation(Formulation formulation) {
        this.formulation = formulation;
    }



    public int getDistegretionTime() {
        return distegretionTime;
    }

    public void setDistegretionTime(int distegretionTime) {
        this.distegretionTime = distegretionTime;
    }

    public double getFriability() {
        return friability;
    }

    public void setFriability(double friability) {
        this.friability = friability;
    }

    public List<Double> getDissolutionProfile() {
        return dissolutionProfile;
    }

    public void setDissolutionProfile(List<Double> dissolutionProfile) {
        this.dissolutionProfile = dissolutionProfile;
    }

    public String getInstraction() {
        return instraction;
    }

    public void setInstraction(String instraction) {
        this.instraction = instraction;
    }

    public String getFormulationName() {
        return formulationName;
    }

    public void setFormulationName(String formulationName) {
        this.formulationName = formulationName;
    }

    public DFProperty getDfProperty() {
        return dfProperty;
    }

    public void setDfProperty(DFProperty dfProperty) {
        this.dfProperty = dfProperty;
    }
}
