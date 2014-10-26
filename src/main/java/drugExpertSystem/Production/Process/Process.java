package drugExpertSystem.Production.Process;

import drugExpertSystem.Production.UnitOperation.UnitOperation;

import java.util.List;

/**
 * Created by Panupak on 8/21/2014.
 */
public class Process {
    String dosageForm;
    List<UnitOperation> unitOperations;

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public List<UnitOperation> getUnitOperations() {
        return unitOperations;
    }

    public void setUnitOperations(List<UnitOperation> unitOperations) {
        this.unitOperations = unitOperations;
    }
}
