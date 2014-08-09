package drugExpertSystem.substance.Service.substanceFunctionService;

import drugExpertSystem.substance.DAO.SequeceNumber.SequenceDao;
import drugExpertSystem.substance.Entity.SubstanceFunction.CompoundFunction;
import drugExpertSystem.substance.repository.CompoundFunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Panupak on 6/8/2014.
 */
@Service
public class CompoundFunctionServiceImpl implements CompoundFunctionService {
    @Autowired
    CompoundFunctionRepository compoundFunctionRepository;

    @Autowired
    SequenceDao sequenceDao;

    @Override
    @Transactional
    public CompoundFunction add(CompoundFunction compoundFunction) {
        compoundFunction.setId(sequenceDao.getNextSequenceId("compoundFunction"));
        compoundFunctionRepository.save(compoundFunction);

        try{
            this.getByID(compoundFunction.getId());
        }catch (Exception e){
            return null;
        }

        return compoundFunction;
    }

    @Override
    @Transactional
    public CompoundFunction update(CompoundFunction compoundFunction) {
        compoundFunctionRepository.save(compoundFunction);

        try{
            this.getByID(compoundFunction.getId());
        }catch (Exception e){
            return null;
        }

        return compoundFunction;
    }

    @Override
    @Transactional
    public CompoundFunction delete(CompoundFunction compoundFunction) {
        compoundFunctionRepository.delete(compoundFunction);

        return compoundFunction;
    }

    @Override
    @Transactional
    public List<CompoundFunction> getAll() {
        return compoundFunctionRepository.findAll();
    }

    @Override
    @Transactional
    public CompoundFunction getByID(long id) {
        return compoundFunctionRepository.findById(id);
    }

    @Override
    @Transactional
    public CompoundFunction getByType(String type) {
        return compoundFunctionRepository.findByType(type);
    }
}
