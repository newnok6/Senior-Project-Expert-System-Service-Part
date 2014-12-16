package drugExpertSystem.controller;


import drugExpertSystem.excipient.Excipient;
import drugExpertSystem.excipient.services.ExcipientService;
import drugExpertSystem.substance.Entity.SubstanceFunction.SubstanceFunction;
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
    public void addExcipient(@RequestBody Excipient excipient){
        excipientService.addExcipient(excipient);
        System.out.println("Excipient adding sucessful");
    }

    @RequestMapping(value = "update-excipient",method = RequestMethod.PUT)
    public  @ResponseBody
    void updateExcipient(@RequestBody Excipient excipient){
        excipientService.updateExcipient(excipient);
    }

    @RequestMapping(value = "remove-excipient/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody void deleteExcipient(@PathVariable("id") String id){
        excipientService.deleteExcipient(excipientService.getExcipientById(id));
    }


    @RequestMapping(value = "/excipientList.json",method = RequestMethod.GET)
    public List<Excipient> getAllExcipient(){
        return excipientService.getAllExcipient();
    }

    //@RequestMapping(value = "/substanceListForExcipient.json",method = RequestMethod.GET)
    //public List<Substance> getAllSubstance(){
      //  return excipientService.getSubstanceForExcipient();
    //}

}
