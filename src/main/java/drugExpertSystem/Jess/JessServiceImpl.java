package drugExpertSystem.Jess;

import drugExpertSystem.excipient.ExcipientRepository;

import drugExpertSystem.formulation.Repository.FormulationRepository;
import drugExpertSystem.substance.repository.SubstanceRepository;
import jess.JessException;
import jess.Rete;
import jess.WorkingMemoryMarker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Panupak on 10/2/2014.
 */
@Service
public class JessServiceImpl implements JessService {


    @Autowired
    SubstanceRepository substanceRepository;
    @Autowired
    ExcipientRepository excipientRepository;
    @Autowired
    FormulationRepository formulationRepository;


    private Rete rete;
    private WorkingMemoryMarker marker;

    @Override
    @Transactional
    public void addBaseFact() {
        // Create Rule Engine //
        rete = new Rete();

        try {

            rete.reset();

            // Load Drug Expert System rule //
            rete.batch("templateFromClass.clp");
            rete.addAll(substanceRepository.findAll());
            rete.addAll(excipientRepository.findAll());
            rete.addAll(formulationRepository.findAll());

            // Mark end of catalog data for later
            marker = rete.mark();
            rete.eval("(facts)");
           // rete.run();
           // rete.eval(("facts"));

        } catch (JessException e) {
            e.printStackTrace();
        }

    }

    @Override
    @Transactional
    public Rete getFact() {
        return null;
    }

}
