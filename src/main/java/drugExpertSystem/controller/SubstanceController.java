package drugExpertSystem.controller;

import drugExpertSystem.substance.Entity.SubstancePackage.Substance;
import drugExpertSystem.substance.Service.substanceService.SubstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Panupak on 5/23/2014.
 */
@Controller
@RequestMapping("/substance")
public class SubstanceController {

  @Autowired
    SubstanceService substanceService;

    @RequestMapping(value = "add-substance",method = RequestMethod.POST)
    public  @ResponseBody
    void addSolubility(@RequestBody Substance substance){
        substanceService.addsubstance(substance);
        System.out.println("test");
    }

    @RequestMapping(value = "update-substance/{id}",method = RequestMethod.PUT)
    public  @ResponseBody void updateSolubility(@RequestBody Substance substance){
        substanceService.updateSubstance(substance);
    }

    @RequestMapping(value = "remove-substance/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody void deleteSolubility(@PathVariable("id") Long id){
        substanceService.deleteSubstance(substanceService.getSubstanceById(id));
    }

    @RequestMapping(value = "substanceList.json",method = RequestMethod.GET)
    public @ResponseBody
    List<Substance> getAllSolubility(){
        return substanceService.getAllSubstance();
    }



}
