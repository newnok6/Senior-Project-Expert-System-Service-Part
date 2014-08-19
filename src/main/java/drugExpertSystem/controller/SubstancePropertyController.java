package drugExpertSystem.controller;


import drugExpertSystem.substance.Entity.SubstancePackage.Substance;
import drugExpertSystem.substance.Entity.substanceProperty.Solubility;

import drugExpertSystem.substance.Service.substanceService.SubstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Panupak on 5/22/2014.
 */
@Controller
@RequestMapping("/subprop")
public class SubstancePropertyController {


    @RequestMapping(value = "solubilityList",method = RequestMethod.GET)
        public @ResponseBody
        Solubility[] getAllSolubility(){
            return Solubility.values();

    }



}
