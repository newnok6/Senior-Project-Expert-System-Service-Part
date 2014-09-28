package drugExpertSystem.controller;

import drugExpertSystem.excipient.Excipient;
import drugExpertSystem.excipient.services.ExcipientService;
import drugExpertSystem.formulation.Formulation;
import drugExpertSystem.formulation.Services.FormulationService;
import drugExpertSystem.substance.Entity.SubstancePackage.Substance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Panupak on 9/27/2014.
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

    @RequestMapping(value = "update-formulation/{id}",method = RequestMethod.PUT)
    public  @ResponseBody
    void updateSubstance(@RequestBody Formulation formulation){
        formulationService.addFormulation(formulation);
    }

    @RequestMapping(value = "remove-formulation/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody void deleteSubstance(@PathVariable("id") Long id){
        formulationService.deleteFormulation(formulationService.getFormulationById(id));
    }

    @RequestMapping(value = "/excipientList.json",method = RequestMethod.GET)
    public List<Formulation> getAllSubstance(){
        return formulationService.getAllFormulation();
    }

}
