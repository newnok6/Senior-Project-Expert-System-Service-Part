package drugExpertSystem.InferenceEngine.CaseBaseReasoningEngine.SolAndDisc;

import drugExpertSystem.substance.Entity.substanceProperty.Solubility;

import java.util.List;

/**
 * Created by Panupak on 11/10/2014.
 */
public interface SolAndDescService {
    public SolAndDesc addSolAndDesc(SolAndDesc solAndDesc);
    public SolAndDesc updateSolAndDesc(SolAndDesc solAndDesc);
    public SolAndDesc deleteSolAndDesc(SolAndDesc solAndDesc);
    public SolAndDesc getSolAndDesc(String id);
    public List<SolAndDesc> getAllSolAndDesc();
}
