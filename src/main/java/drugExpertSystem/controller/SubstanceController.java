package drugExpertSystem.controller;

import drugExpertSystem.Model.Substance;
import drugExpertSystem.substance.Service.substanceService.SubstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Panupak on 5/23/2014.
 */
@RestController
@RequestMapping("/substance")
public class SubstanceController {

  @Autowired
    SubstanceService substanceService;


    @RequestMapping(value = "/add-substance",method = RequestMethod.POST)
    public @ResponseBody List<Substance> addSubstance(@RequestBody Substance substance){
        substanceService.addsubstance(substance);
        return substanceService.getAllSubstance();
        //System.out.println("Substance adding sucessful");
    }

    @RequestMapping(value = "update-substance",method = RequestMethod.PUT)
    public void updateSubstance(@RequestBody Substance substance){
        substanceService.updateSubstance(substance);
    }

    @RequestMapping(value = "remove-substance/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody void deleteSubstance(@PathVariable("id") String id){
        substanceService.deleteSubstance(substanceService.getSubstanceById(id));
    }

    @RequestMapping(value = "/substanceList.json",method = RequestMethod.GET)
    public @ResponseBody List<Substance> getAllSubstance(){
        return substanceService.getAllSubstance();
    }



}
