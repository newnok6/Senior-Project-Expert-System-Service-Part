package drugExpertSystem.formulation;

import drugExpertSystem.excipient.Excipient;

import java.util.List;

/**
 * Created by Panupak on 8/19/2014.
 */
public class Formulation {
    long id;
    List<Excipient> api;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Excipient> getApi() {
        return api;
    }

    public void setApi(List<Excipient> api) {
        this.api = api;
    }
}
