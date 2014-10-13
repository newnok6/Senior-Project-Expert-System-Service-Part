package drugExpertSystem.formulation;

import drugExpertSystem.Model.Excipient;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Panupak on 8/19/2014.
 */
@Document
public class Formulation {
    @Id
    String id;
    String name;
    String type;
    List<Excipient> api;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Excipient> getApi() {
        return api;
    }

    public void setApi(List<Excipient> api) {
        this.api = api;
    }
}
