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
    List<Excipient> binder;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Excipient> getBinder() {
        return binder;
    }

    public void setBinder(List<Excipient> binder) {
        this.binder = binder;
    }
}
