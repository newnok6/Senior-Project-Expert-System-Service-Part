package drugExpertSystem.Production;

import drugExpertSystem.formulation.Formulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Panupak on 10/12/2014.
 */
@Service

public class ProductionServiceImpl implements ProductionService {



    @Autowired
    ProductionRepository productionRepository;

    @Override
    @Transactional
    public Production createProduction(Production production) {
        try{
            productionRepository.save(production);

        }catch (Exception e){
            e.printStackTrace();
        }
        return production;
    }

    @Override
    @Transactional
    public Production updateProduction(Production production) {
        try{
            productionRepository.save(production);
        }catch (Exception e){
            return null;
        }
        return production;
    }

    @Override
    @Transactional
    public Production removeProduction(String id) {
        try{
            productionRepository.delete(this.getProductionById(id));

        }catch (Exception e){
            return this.getProductionById(id);
        }
        return null;
    }

    @Override
    @Transactional
    public List<Production> getAllProduction() {

            return productionRepository.findAll();



    }

    @Override
    @Transactional
    public Production getProductionById(String id) {
        return productionRepository.findOne(id);
    }

    @Override
    @Transactional
    public List<Formulation> getFormulationForProduction() {
        //List<Formulation>
        return null;
    }
}
