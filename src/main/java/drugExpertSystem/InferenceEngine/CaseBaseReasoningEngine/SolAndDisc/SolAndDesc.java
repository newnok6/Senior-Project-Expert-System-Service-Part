package drugExpertSystem.InferenceEngine.CaseBaseReasoningEngine.SolAndDisc;

import drugExpertSystem.Production.Production;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Panupak on 11/10/2014.
 */


@Document
public class SolAndDesc {
    @Id
    String id;
    Production solutionProduction;
    Production description;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Production getSolutionProduction() {
        return solutionProduction;
    }

    public void setSolutionProduction(Production solutionProduction) {
        this.solutionProduction = solutionProduction;
    }

    public Production getDescription() {
        return description;
    }

    public void setDescription(Production description) {
        this.description = description;
    }
}
