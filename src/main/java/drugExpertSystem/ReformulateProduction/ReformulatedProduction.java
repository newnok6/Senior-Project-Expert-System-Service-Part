package drugExpertSystem.ReformulateProduction;

import drugExpertSystem.Production.Production;
import drugExpertSystem.User.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Panupak on 10/7/2014.
 */
public class ReformulatedProduction {
    String id;
    Production production;
    boolean accept;
    String inferenceEngine;

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

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public String getInferenceEngine() {
        return inferenceEngine;
    }

    public void setInferenceEngine(String inferenceEngine) {
        this.inferenceEngine = inferenceEngine;
    }
}
