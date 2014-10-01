package drugExpertSystem.controller.FormulationControllers;

import drugExpertSystem.formulation.Services.SolutionFormulationService;
import drugExpertSystem.formulation.SolutionFormulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Panupak on 10/1/2014.
 */
@RestController
@RequestMapping("/solution-formulation")
public class SolutionFormulationController {
    @Autowired
    SolutionFormulationService solutionFormulationService;

    @RequestMapping(value = "/add-solution-formulation",method = RequestMethod.POST)
    public void addSubstance(@RequestBody SolutionFormulation solutionFormulation){
        solutionFormulationService.addFormulation(solutionFormulation);
        System.out.println("Formulation adding sucessful");
    }

    @RequestMapping(value = "/update-solution-formulation",method = RequestMethod.PUT)
    public  @ResponseBody
    void updateSubstance(@RequestBody SolutionFormulation solutionFormulation){
        solutionFormulationService.updateFormulation(solutionFormulation);
    }

    @RequestMapping(value = "/remove-solution-formulation/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody
    void deleteSubstance(@PathVariable("id") String id){
        solutionFormulationService.deleteFormulation(solutionFormulationService.getFormulation(id));
    }

    @RequestMapping(value = "/solutionformulationList.json",method = RequestMethod.GET)
    public List<SolutionFormulation> getAllSubstance(){
        return solutionFormulationService.getAllFormulation();
    }
}
