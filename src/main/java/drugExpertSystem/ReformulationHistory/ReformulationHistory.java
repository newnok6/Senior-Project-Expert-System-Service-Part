package drugExpertSystem.ReformulationHistory;

import drugExpertSystem.ReformulateProduction.ReformulatedProduction;
import drugExpertSystem.User.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * Created by Panupak on 10/11/2014.
 */
@Document
public class ReformulationHistory {
    @Id
    String id;
    List<ReformulatedProduction> reformulatedProductionList;
    Date date;
    User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ReformulatedProduction> getReformulatedProductionList() {
        return reformulatedProductionList;
    }

    public void setReformulatedProductionList(List<ReformulatedProduction> reformulatedProductionList) {
        this.reformulatedProductionList = reformulatedProductionList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
