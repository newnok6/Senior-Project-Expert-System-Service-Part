package drugExpertSystem.Production;


import
        drugExpertSystem.Production.DFProperties.DFProperty;
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
    String id;
   // Process process;
    Formulation formulation;
   //List<QualityControl> qualityControlList;
    DFProperty dfProperty;

    @TextIndexed
    String instraction;
    float formulationWeight;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Formulation getFormulation() {
        return formulation;
    }

    public void setFormulation(Formulation formulation) {
        this.formulation = formulation;
    }

    public String getInstraction() {
        return instraction;
    }

    public void setInstraction(String instraction) {
        this.instraction = instraction;
    }

    public DFProperty getDfProperty() {
        return dfProperty;
    }

    public void setDfProperty(DFProperty dfProperty) {
        this.dfProperty = dfProperty;
    }



    public float getFormulationWeight() {
       return formulationWeight;
   }

   public void setFormulationWeight(float formulationWeight) {
       this.formulationWeight = formulationWeight;
   }
}
