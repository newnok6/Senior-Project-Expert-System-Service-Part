package drugExpertSystem.controller.FormulationControllers;

import drugExpertSystem.formulation.Services.TabletFormulationService;
import drugExpertSystem.Model.TabletFormulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Panupak on 10/1/2014.
 */
@RestController
@RequestMapping("/tablet-formulation")
public class TabletFormulationController {
    @Autowired
    TabletFormulationService tabletFormulationService;

    @RequestMapping(value = "/add-tablet-formulation",method = RequestMethod.POST)
    public void addSubstance(@RequestBody TabletFormulation tabletFormulation){
        tabletFormulationService.addFormulation(tabletFormulation);
        System.out.println("Formulation adding sucessful");
    }

    @RequestMapping(value = "/update-tablet-formulation",method = RequestMethod.PUT)
    public  @ResponseBody
    void updateSubstance(@RequestBody TabletFormulation tabletFormulation){
        tabletFormulationService.updateFormulation(tabletFormulation);
    }

    @RequestMapping(value = "/remove-tablet-formulation/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody
    void deleteSubstance(@PathVariable("id") String id){
        tabletFormulationService.deleteFormulation(tabletFormulationService.getFormulation(id));
    }

    @RequestMapping(value = "/tabletformulationList.json",method = RequestMethod.GET)
    public List<TabletFormulation> getAllSubstance(){
        return tabletFormulationService.getAllFormulation();
    }
}
