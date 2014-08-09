package drugExpertSystem.substance.Service.substancePropertyService;

import drugExpertSystem.substance.DAO.SequeceNumber.SequenceDao;
import drugExpertSystem.substance.Entity.substanceProperty.Density;
import drugExpertSystem.substance.repository.DensityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Panupak on 6/8/2014.
 */
@Service
public class DensityServiceImpl implements DensityService {
    @Autowired
   DensityRepository densityRepository;

    @Autowired
    SequenceDao sequenceDao;

    @Override
    @Transactional
    public Density add(Density density) {
        density.setId(sequenceDao.getNextSequenceId("density"));
        densityRepository.save(density);
        try{
            this.getByID(density.getId());
        }catch (Exception e){
            return null;
        }

        return density;

    }

    @Override
    @Transactional
    public Density update(Density density) {

        densityRepository.save(density);

        try{
            this.getByID(density.getId());
        }catch (Exception e){
            return null;
        }

        return density;
    }

    @Override
    @Transactional
    public Density delete(Density density) {

        densityRepository.delete(density);

        return density;
    }

    @Override
    @Transactional
    public List<Density> getAll() {
        return densityRepository.findAll();
    }

    @Override
    @Transactional
    public Density getByID(long id) {
        return densityRepository.findById(id);
    }

    @Override
    @Transactional
    public Density getByType(String type) {
        return densityRepository.findByType(type);
    }
}
