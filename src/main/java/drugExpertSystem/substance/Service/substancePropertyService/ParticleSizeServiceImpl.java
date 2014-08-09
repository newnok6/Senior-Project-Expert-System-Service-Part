package drugExpertSystem.substance.Service.substancePropertyService;

import drugExpertSystem.substance.DAO.SequeceNumber.SequenceDao;
import drugExpertSystem.substance.Entity.substanceProperty.ParticleSize;
import drugExpertSystem.substance.repository.ParticleSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Panupak on 6/8/2014.
 */
@Service
public class ParticleSizeServiceImpl implements ParticleSizeService {
    @Autowired
    ParticleSizeRepository particleSizeRepository;

    @Autowired
    SequenceDao sequenceDao;

    @Override
    @Transactional
    public ParticleSize add(ParticleSize particleSize) {
        particleSize.setId(sequenceDao.getNextSequenceId("particleSize"));
        particleSizeRepository.save(particleSize);

        try{
            this.getByID(particleSize.getId());
        }catch (Exception e){
            return null;
        }

        return particleSize;
    }

    @Override
    @Transactional
    public ParticleSize update(ParticleSize particleSize) {

        particleSizeRepository.save(particleSize);

        try{
            this.getByID(particleSize.getId());
        }catch (Exception e){
            return null;
        }

        return particleSize;
    }

    @Override
    @Transactional
    public ParticleSize delete(ParticleSize particleSize) {

        particleSizeRepository.delete(particleSize);

        return particleSize;
    }

    @Override
    @Transactional
    public List<ParticleSize> getAll() {
        return particleSizeRepository.findAll();
    }

    @Override
    @Transactional
    public ParticleSize getByID(long id) {
        return particleSizeRepository.findById(id);
    }

    @Override
    @Transactional
    public ParticleSize getByType(String type) {
        return particleSizeRepository.findByType(type);
    }
}
