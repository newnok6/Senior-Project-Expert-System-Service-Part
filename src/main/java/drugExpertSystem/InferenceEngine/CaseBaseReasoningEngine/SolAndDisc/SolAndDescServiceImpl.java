package drugExpertSystem.InferenceEngine.CaseBaseReasoningEngine.SolAndDisc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Panupak on 11/10/2014.
 */
@Service
public class SolAndDescServiceImpl implements SolAndDescService {
    @Autowired
    SolAndDescRepository solAndDescRepository;

    @Override
    @Transactional
    public SolAndDesc addSolAndDesc(SolAndDesc solAndDesc) {
        solAndDescRepository.save(solAndDesc);
        return solAndDesc;
    }

    @Override
    @Transactional
    public SolAndDesc updateSolAndDesc(SolAndDesc solAndDesc) {
       solAndDescRepository.save(solAndDesc);
        return solAndDesc;
    }

    @Override
    @Transactional
    public SolAndDesc deleteSolAndDesc(SolAndDesc solAndDesc) {
        solAndDescRepository.delete(solAndDesc);
        return solAndDesc;
    }

    @Override
    @Transactional
    public SolAndDesc getSolAndDesc(String id) {
        return solAndDescRepository.findOne(id);
    }

    @Override
    @Transactional
    public List<SolAndDesc> getAllSolAndDesc() {
        return solAndDescRepository.findAll();
    }
}
