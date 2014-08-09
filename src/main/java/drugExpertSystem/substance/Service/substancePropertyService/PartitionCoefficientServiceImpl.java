package drugExpertSystem.substance.Service.substancePropertyService;

import drugExpertSystem.substance.DAO.SequeceNumber.SequenceDao;
import drugExpertSystem.substance.Entity.substanceProperty.PartitionCoefficient;
import drugExpertSystem.substance.repository.PartitionCoefficientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Panupak on 6/8/2014.
 */
@Service
public class PartitionCoefficientServiceImpl implements PartitionCoefficientService {
    @Autowired
    PartitionCoefficientRepository partitionCoefficientRepository;

    @Autowired
    SequenceDao sequenceDao;

    @Override
    @Transactional
    public PartitionCoefficient add(PartitionCoefficient partitionCoefficient) {
        partitionCoefficient.setId(sequenceDao.getNextSequenceId("partitionCoefficient"));
        partitionCoefficientRepository.save(partitionCoefficient);

        try{
            this.getByID(partitionCoefficient.getId());
        }catch (Exception e){
            return null;
        }

        return partitionCoefficient;
    }

    @Override
    @Transactional
    public PartitionCoefficient update(PartitionCoefficient partitionCoefficient) {
        partitionCoefficientRepository.save(partitionCoefficient);

        try{
            this.getByID(partitionCoefficient.getId());
        }catch (Exception e){
            return null;
        }

        return partitionCoefficient;
    }

    @Override
    @Transactional
    public PartitionCoefficient delete(PartitionCoefficient partitionCoefficient) {
        partitionCoefficientRepository.delete(partitionCoefficient);

        return partitionCoefficient;
    }

    @Override
    @Transactional
    public List<PartitionCoefficient> getAll() {
        return partitionCoefficientRepository.findAll();
    }

    @Override
    @Transactional
    public PartitionCoefficient getByID(long id) {
        return partitionCoefficientRepository.findById(id);
    }

    @Override
    @Transactional
    public PartitionCoefficient getByType(String type) {
        return partitionCoefficientRepository.findByType(type);
    }
}
