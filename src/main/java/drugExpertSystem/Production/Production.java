package drugExpertSystem.Production;

import drugExpertSystem.Production.QualityControl.QualityControl;
import drugExpertSystem.formulation.Formulation;

import java.util.List;

/**
 * Created by Panupak on 8/21/2014.
 */
public class Production {
    long id;
    Process process;
    Formulation formulation;
    List<QualityControl> qualityControlList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Formulation getFormulation() {
        return formulation;
    }

    public void setFormulation(Formulation formulation) {
        this.formulation = formulation;
    }

    public List<QualityControl> getQualityControlList() {
        return qualityControlList;
    }

    public void setQualityControlList(List<QualityControl> qualityControlList) {
        this.qualityControlList = qualityControlList;
    }
}
