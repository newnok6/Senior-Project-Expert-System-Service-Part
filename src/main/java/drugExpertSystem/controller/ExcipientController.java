package drugExpertSystem.controller;

import drugExpertSystem.excipient.Excipient;
import drugExpertSystem.excipient.services.ExcipientService;
import drugExpertSystem.formulation.Formulation;
import drugExpertSystem.substance.Entity.SubstancePackage.Substance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Panupak on 9/27/2014.
 */
@RestController
@RequestMapping("/excipient")
public class ExcipientController {
    @Autowired
    ExcipientService excipientService;


    @RequestMapping(value = "/add-excipient",method = RequestMethod.POST)
    public void addSubstance(@RequestBody Excipient excipient){
        excipientService.addExcipient(excipient);
        System.out.println("Excipient adding sucessful");
    }

    @RequestMapping(value = "update-excipient",method = RequestMethod.PUT)
    public  @ResponseBody
    void updateSubstance(@RequestBody Excipient excipient){
        excipientService.updateExcipient(excipient);
    }

    @RequestMapping(value = "remove-excipient/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody void deleteSubstance(@PathVariable("id") Long id){
        excipientService.deleteExcipient(excipientService.getExcipientById(id));
    }

    @RequestMapping(value = "/excipientList.json",method = RequestMethod.GET)
    public List<Excipient> getAllSubstance(){
        return excipientService.getAllExcipient();
    }

}
