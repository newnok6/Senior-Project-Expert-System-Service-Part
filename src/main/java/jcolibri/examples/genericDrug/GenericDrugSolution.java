package jcolibri.examples.genericDrug;

import drugExpertSystem.Production.Production;
import jcolibri.cbrcore.Attribute;

/**
 * Created by COMPAQ on 7/11/2557.
 */
public class GenericDrugSolution implements jcolibri.cbrcore.CaseComponent{
    String id;
    Production production;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    @Override
    public Attribute getIdAttribute() {
        return new Attribute("id", this.getClass());
    }
}
