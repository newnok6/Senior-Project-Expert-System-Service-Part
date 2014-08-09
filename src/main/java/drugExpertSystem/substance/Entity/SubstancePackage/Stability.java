package drugExpertSystem.substance.Entity.SubstancePackage;

import drugExpertSystem.substance.Entity.substanceProperty.DegradationMechanism;
import drugExpertSystem.substance.Entity.substanceProperty.KineticReaction;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Stability {
    @Id
    long id;

    @DBRef
    List<DegradationMechanism> degradationMechanismList;
    @DBRef
    KineticReaction kineticreaction;

    public List<DegradationMechanism> getDegradationMechanismList() {
        return degradationMechanismList;
    }

    public void setDegradationMechanismList(List<DegradationMechanism> degradationMechanismList) {
        this.degradationMechanismList = degradationMechanismList;
    }

    public KineticReaction getKineticreaction() {
        return this.kineticreaction;
    }

    public void setKineticreaction(KineticReaction kineticreaction) {

        this.kineticreaction = kineticreaction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}