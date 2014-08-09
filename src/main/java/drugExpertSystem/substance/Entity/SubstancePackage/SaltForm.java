package drugExpertSystem.substance.Entity.SubstancePackage;


import drugExpertSystem.substance.Entity.substanceProperty.Pka;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SaltForm{

    @Id
    long id;

    float molecularweightproperty;

    @DBRef
    Pka pkaproperty;

    public float getMolecularweightproperty() {
        return this.molecularweightproperty;
    }

    public void setMolecularweightproperty(float molecularweightproperty) {
        this.molecularweightproperty = molecularweightproperty;
    }

    public Pka getPkaproperty() {
        return pkaproperty;
    }

    public void setPkaproperty(Pka pkaproperty) {
        this.pkaproperty = pkaproperty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}