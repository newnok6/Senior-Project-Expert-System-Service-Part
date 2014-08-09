package drugExpertSystem.controller;

import drugExpertSystem.substance.Entity.SubstanceFunction.CompoundFunction;

import drugExpertSystem.substance.Entity.substanceProperty.*;

import drugExpertSystem.substance.Service.substancePropertyService.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * Created by Panupak on 5/22/2014.
 */
@Controller
@RequestMapping("/subprop")
public class SubstancePropertyController {

    @Autowired
    SolubilityService solubilityService;

    @Autowired
    SolidstateService solidstateService;

    @Autowired
    PkaService pkaService;

    @Autowired
    DegradationMechanismService degradationMechanismService;

    @Autowired
    KineticReactionService kineticReactionService;

    @Autowired
    DensityService densityService;

    @Autowired
    ParticleSizeService particleSizeService;

    @Autowired
    PartitionCoefficientService partitionCoefficientService;

    @Autowired
    HygroscopicityService hygroscopicityService;

    @Autowired
    FlowabilityService flowabilityService;


@RequestMapping
public String showSubpropertyPage(){
    return "adminhtml/substanceIndexProp";
}

  @RequestMapping(value = "/solubilityList.json",method = RequestMethod.GET)
  public @ResponseBody List<Solubility> getAllSolubility(){
      return solubilityService.getAll();
  }

  @RequestMapping(value = "/solidstateList.json",method = RequestMethod.GET)
  public @ResponseBody List<Solidstate> getAllSolidState(){
      return solidstateService.getAll();
  }
/*
    @RequestMapping
    public String callIndexPage(Model model) {

       // model.addAttribute("solubilityList", solubilityService.getAll());
       // model.addAttribute("kineticReactionList", kineticReactionService.getAll());
       // model.addAttribute("pkaList", pkaService.getAll());
       // model.addAttribute("partitionCoefficientList", partitionCoefficientService.getAll());
       // model.addAttribute("solidstateList", solidstateService.getAll());
       // model.addAttribute("hygroscopicityList", hygroscopicityService.getAll());
       // model.addAttribute("particleSizeList", particleSizeService.getAll());
       // model.addAttribute("flowabilityList", flowabilityService.getAll());
       // model.addAttribute("desityList", densityService.getAll());
       //model.addAttribute("compoundFunctionList",.gellAll());
     //  model.addAttribute("degradationMechanismList",degradationMechanismService.getAll());
        return "admin/addExcipientProp";
    }
    */
/*
    @RequestMapping("/solubilityList")
    public @ResponseBody
    List<Solubility> getAllSolubility(){
        System.out.println("testCalled");
        //return solubilityService.getAll();
    }
    */

    @RequestMapping("excipient")
    public View gotoSubstancePage(Model model) {
        return new RedirectView("substancemanagement/substanceIndex");
    }
    @RequestMapping(value = "addNewSolubility", method = RequestMethod.GET)
    public View createSolubility(@ModelAttribute Solubility solubility, ModelMap modelMap) {

       // solubilityService.add(solubility);
        return new RedirectView("propertyIndex");
    }

    @RequestMapping(value = "addNewDegradationMechanism", method = RequestMethod.GET)
    public View createDegradationMechanism(@ModelAttribute DegradationMechanism degradationMechanism, ModelMap modelMap) {

        //degradationMechanismService.add(degradationMechanism);
        return new RedirectView("propertyIndex");
    }


    @RequestMapping(value = "addNewKineticReaction", method = RequestMethod.GET)
    public View createKineticReaction(@ModelAttribute KineticReaction kineticReaction, ModelMap modelMap) {
       // kineticReactionService.add(kineticReaction);
        return new RedirectView("propertyIndex");
    }

    @RequestMapping(value = "addNewPka", method = RequestMethod.GET)
    public View createPka(@ModelAttribute Pka pka, ModelMap modelMap) {
      // pkaService.add(pka);
        return new RedirectView("propertyIndex");
    }
    @RequestMapping(value = "addNewPartitionCoefficient", method = RequestMethod.GET)
    public View createPartitionCoefficient(@ModelAttribute PartitionCoefficient partitionCoefficient, ModelMap modelMap) {
       //partitionCoefficientService.add(partitionCoefficient);
        return new RedirectView("propertyIndex");
    }
    @RequestMapping(value = "addNewSolidstate", method = RequestMethod.GET)
    public View createSolidstate(@ModelAttribute Solidstate solidstate, ModelMap modelMap) {
       //solidstateService.add(solidstate);
        return new RedirectView("propertyIndex");
    }
    @RequestMapping(value = "addNewHygroscopicity", method = RequestMethod.GET)
    public View createHygroscopicity(@ModelAttribute Hygroscopicity hygroscopicity, ModelMap modelMap) {
      // hygroscopicityService.add(hygroscopicity);
        return new RedirectView("propertyIndex");
    }
    @RequestMapping(value = "addNewParticleSize", method = RequestMethod.GET)
    public View createParticleSize(@ModelAttribute ParticleSize particleSize, ModelMap modelMap) {
      // particleSizeService.add(particleSize);
        return new RedirectView("propertyIndex");
    }

    @RequestMapping(value = "addNewFlowability", method = RequestMethod.GET)
    public View createFlowability(@ModelAttribute Flowability flowability, ModelMap modelMap) {
       /// flowabilityService.add(flowability);
        return new RedirectView("propertyIndex");
    }

    @RequestMapping(value = "addNewDensity", method = RequestMethod.GET)
    public View createDensity(@ModelAttribute Density density, ModelMap modelMap) {
        //densityService.add(density);
        return new RedirectView("propertyIndex");
    }

    @RequestMapping(value = "addNewCompoundFunction", method = RequestMethod.GET)
    public View createCompoundFunction(@ModelAttribute CompoundFunction compoundFunction, ModelMap modelMap) {
      //  compoundFunctionService.add(compoundFunction);
        return new RedirectView("propertyIndex");
    }

}
