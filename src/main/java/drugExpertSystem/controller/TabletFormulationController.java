package drugExpertSystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by Panupak on 5/24/2014.
 */
@Controller
@RequestMapping("tabletformulation")
public class TabletFormulationController {

   // @Autowired
    //SubstanceService substanceService;

   // @Autowired
   // CompoundFunctionService compoundFunctionService;

    @RequestMapping("index")
    public String tabletFormulationIndex(ModelMap modelMap){
       // modelMap.addAttribute("substanceList",substanceService.getAllSubstance());
        //modelMap.addAttribute("compoundFunctionList",compoundFunctionService.getAllCompoundFunction());
        return "admin/tabletFormulationManagement";
    }

    @RequestMapping(value = "addFormulation",method = RequestMethod.GET)
    public View addNewFormulation(@RequestParam("substanceId") long[] substanceId){
        for (long sub : substanceId){
            System.out.println(sub);
        }
        return new RedirectView("index");
    }
}
