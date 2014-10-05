package drugExpertSystem.formulation.Services;

import drugExpertSystem.formulation.Repository.TabletFormulationRepository;
import drugExpertSystem.Model.TabletFormulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Panupak on 9/30/2014.
 */
@Service
public class TabletFormulationServiceImpl implements TabletFormulationService {

    @Autowired
    TabletFormulationRepository tabletFormulationRepository;


    @Override
    @Transactional
    public TabletFormulation addFormulation(TabletFormulation tabletFormulation) {
        tabletFormulationRepository.save(tabletFormulation);
        try{
            this.getFormulation(tabletFormulation.getId());
        }catch (Exception e){
            return null;
        }

        return tabletFormulation;
    }

    @Override
    @Transactional
    public TabletFormulation updateFormulation(TabletFormulation tabletFormulation) {
        TabletFormulation tabletFormulationInDb = tabletFormulationRepository.findOne(tabletFormulation.getId());
        tabletFormulationInDb.setApi(tabletFormulation.getApi());
        tabletFormulationRepository.save(tabletFormulationInDb);
        try{
            this.getFormulation(tabletFormulation.getId());
        }catch (Exception e){
            return null;
        }

        return tabletFormulation;
    }

    @Override
    @Transactional
    public TabletFormulation deleteFormulation(TabletFormulation tabletFormulation) {
        tabletFormulationRepository.delete(tabletFormulation);
        try{
            this.getFormulation(tabletFormulation.getId());
        }catch (Exception e){
            return null;
        }

        return tabletFormulation;
    }

    @Override
    @Transactional
    public List<TabletFormulation> getAllFormulation() {
        return tabletFormulationRepository.findAll();
    }

    @Override
    @Transactional
    public TabletFormulation getFormulation(String id) {
        return tabletFormulationRepository.findOne(id);
    }
}
