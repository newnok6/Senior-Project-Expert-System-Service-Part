package drugExpertSystem.formulation;

import drugExpertSystem.excipient.Excipient;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Panupak on 5/24/2014.
 */
@Document
public class TabletFormulation {
    @Id
    long id;

    String name;

    List<Excipient> excipients;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
}
