package drugExpertSystem.Production.Process;

import drugExpertSystem.Production.UnitOperation.UnitOperation;

import java.util.List;

/**
 * Created by Panupak on 8/21/2014.
 */
public class PharmaceuticalProcess {
    String dosageForm;
    String name;
    List<UnitOperation> unitOperations;

    public PharmaceuticalProcess() {
    }

    public PharmaceuticalProcess(String dosageForm, String name, List<UnitOperation> unitOperations) {
        this.dosageForm = dosageForm;
        this.name = name;
        this.unitOperations = unitOperations;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UnitOperation> getUnitOperations() {
        return unitOperations;
    }

    public void setUnitOperations(List<UnitOperation> unitOperations) {
        this.unitOperations = unitOperations;
    }
}
