package drugExpertSystem.substance.Service.substancePropertyService;

import drugExpertSystem.substance.DAO.SequeceNumber.SequenceDao;
import drugExpertSystem.substance.Entity.substanceProperty.Flowability;
import drugExpertSystem.substance.repository.FlowabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Panupak on 6/8/2014.
 */
@Service
public class FlowabilityServiceImpl implements FlowabilityService
{
    @Autowired
    FlowabilityRepository flowabilityRepository;

    @Autowired
    SequenceDao sequenceDao;

    @Override
    @Transactional
    public Flowability add(Flowability flowability) {
        flowability.setId(sequenceDao.getNextSequenceId("flowability"));
        flowabilityRepository.save(flowability);

        try{
            this.getByID(flowability.getId());
        }catch (Exception e){
            return null;
        }

        return flowability;
    }

    @Override
    @Transactional
    public Flowability update(Flowability flowability) {

        flowabilityRepository.save(flowability);

        try{
            this.getByID(flowability.getId());
        }catch (Exception e){
            return null;
        }

        return flowability;
    }

    @Override
    @Transactional
    public Flowability delete(Flowability flowability) {

        flowabilityRepository.delete(flowability);
        return flowability;
    }

    @Override
    @Transactional
    public List<Flowability> getAll() {
        return flowabilityRepository.findAll();
    }

    @Override
    @Transactional
    public Flowability getByID(long id) {
        return flowabilityRepository.findById(id);
    }

    @Override
    @Transactional
    public Flowability getByType(String type) {
        return flowabilityRepository.findByType(type);
    }
}
