package drugExpertSystem.Production.UnitOperation;



import drugExpertSystem.excipient.Excipient;
import org.springframework.data.annotation.Transient;

import java.util.List;

/**
 * Created by Panupak on 8/21/2014.
 */
public class UnitOperation {
    String name;
    List<Excipient> excipients;

    @Transient
    private int sequence;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Excipient> getExcipients() {
        return excipients;
    }

    public void setExcipients(List<Excipient> excipients) {
        this.excipients = excipients;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}
