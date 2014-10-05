package drugExpertSystem.excipient.services;

import drugExpertSystem.Model.Excipient;
import drugExpertSystem.excipient.ExcipientRepository;
import drugExpertSystem.substance.Entity.SubstanceFunction.BinderFunction;
import drugExpertSystem.substance.Entity.SubstanceFunction.DisintegrantFunction;
import drugExpertSystem.substance.Entity.SubstanceFunction.SubstanceFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Panupak on 9/24/2014.
 */
@Service
public class ExcipientServiceImpl implements ExcipientService {

    @Autowired
    ExcipientRepository excipientRepository;

    //@Autowired
   // SequenceDao sequenceDao;

    List<SubstanceFunction> substanceFunctionList = new ArrayList<SubstanceFunction>();

    @Override
    @Transactional
    public Excipient addExcipient(Excipient excipient) {

        for(SubstanceFunction substanceFunction : excipient.getSubstanceFunctions()){
            this.setSubstanceFunction(substanceFunction);
        }
        excipient.setSubstanceFunctions(substanceFunctionList);
        excipientRepository.save(excipient);
        try{
            this.getExcipientById(excipient.getId());
        }catch (Exception e){
            return null;
        }
        return excipient;
    }

    @Override
    @Transactional
    public Excipient updateExcipient(Excipient excipient) {
        Excipient setdbExcipient = excipientRepository.findOne(excipient.getId());
        setdbExcipient.setMinWeight(excipient.getMinWeight());
        setdbExcipient.setMaxWeight(excipient.getMaxWeight());
        setdbExcipient.setUsedWeight(excipient.getUsedWeight());
        setdbExcipient.setSubstanceFunctions(excipient.getSubstanceFunctions());
        excipientRepository.save(excipient);
        try{
            this.getExcipientById(excipient.getId());
        }catch (Exception e){
            return null;
        }
        return excipient;
    }

    @Override
    @Transactional
    public Excipient deleteExcipient(Excipient excipient) {
        excipientRepository.delete(excipient);
        return excipient;
    }

    @Override
    @Transactional
    public List getAllExcipient() {
        return excipientRepository.findAll();
    }

    @Override
    @Transactional
    public Excipient getExcipientById(String id) {
        return excipientRepository.findOne(id);
    }

    @Override
    @Transactional
    public void setSubstanceFunction(SubstanceFunction substanceFunction) {

        String substanceFnName = substanceFunction.getFunctionName();
        switch (substanceFnName){
            case "binder" :
                BinderFunction binderFunction = new BinderFunction();
                binderFunction.setFunctionName(substanceFunction.getFunctionName());
                binderFunction.setFunctionType(substanceFunction.getFunctionType());
                substanceFunctionList.add(binderFunction);
                break;
            case "disintegrant" :
                DisintegrantFunction disintegrantFunction = new DisintegrantFunction();
                disintegrantFunction.setFunctionName(substanceFunction.getFunctionName());
                disintegrantFunction.setFunctionType(substanceFunction.getFunctionType());
                substanceFunctionList.add(disintegrantFunction);
                break;
            default:
                System.out.println("Can't find Substance Function Classes");
        }

    }

    @Override
    @Transactional
    public List<SubstanceFunction> getSubstaneFunction() {

        return substanceFunctionList;
    }
}
