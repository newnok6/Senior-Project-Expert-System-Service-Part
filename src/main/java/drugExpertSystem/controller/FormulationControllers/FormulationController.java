package drugExpertSystem.controller.FormulationControllers;

import drugExpertSystem.formulation.Formulation;
import drugExpertSystem.formulation.Services.FormulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Panupak on 10/12/2014.
 */
@RestController
@RequestMapping("/formulation")
public class FormulationController {
    @Autowired
    FormulationService formulationService;

    @RequestMapping(value = "/add-formulation",method = RequestMethod.POST)
    public void addSubstance(@RequestBody Formulation formulation){
        formulationService.addFormulation(formulation);
        System.out.println("Formulation adding sucessful");
    }

    @RequestMapping(value = "/update-formulation",method = RequestMethod.PUT)
    public  @ResponseBody
    void updateSubstance(@RequestBody Formulation formulation){
        formulationService.updateFormulation(formulation);
    }

    @RequestMapping(value = "/remove-formulation/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody
    void deleteSubstance(@PathVariable("id") String id){
        formulationService.deleteFormulation(id);
    }

    @RequestMapping(value = "/formulationList.json",method = RequestMethod.GET)
    public List<Formulation> getAllSubstance(){
        return formulationService.getAllFormulation();
    }
}
