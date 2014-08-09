package drugExpertSystem.controller.substancePropertyController;

import drugExpertSystem.substance.Entity.substanceProperty.Solubility;
import drugExpertSystem.substance.Service.substancePropertyService.SolidstateService;
import drugExpertSystem.substance.Service.substancePropertyService.SolubilityService;
import drugExpertSystem.substance.Service.substanceService.SubstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;


import java.util.List;

/**
 * Created by Panupak on 6/8/2014.
 */
@Controller
@RequestMapping("/solubility")
public class SolubilityController {

    @Autowired
    SolubilityService solubilityService;

    @RequestMapping(value = "add-solubility",method = RequestMethod.POST)
    public  @ResponseBody void addSolubility(@RequestBody Solubility solubility){
         solubilityService.add(solubility);
         System.out.println("test");
    }

    @RequestMapping(value = "update-solubility/{id}",method = RequestMethod.PUT)
    public  @ResponseBody void updateSolubility(@RequestBody Solubility solubility){
        solubilityService.update(solubility);
    }

    @RequestMapping(value = "remove-solubility/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody void deleteSolubility(@PathVariable("id") Long id){

        solubilityService.delete(solubilityService.getByID(id));
    }

    @RequestMapping(value = "solubilities.json",method = RequestMethod.GET)
    public @ResponseBody
    List<Solubility> getAllSolubility(){
        return solubilityService.getAll();
    }



/*
    @RequestMapping(value = "addSolubility", method = RequestMethod.GET)
    public View createSolubility(@ModelAttribute Solubility solubility, ModelMap modelMap) {

    }
*/
}
