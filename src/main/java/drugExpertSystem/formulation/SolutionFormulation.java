package drugExpertSystem.formulation;

import drugExpertSystem.excipient.Excipient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Panupak on 8/21/2014.
 */
@Document
public class SolutionFormulation extends Formulation {
    List<Excipient> api;
    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }


    public List<Excipient> getApi() {
        return api;
    }

    public void setApi(List<Excipient> api) {
        this.api = api;
    }
}
