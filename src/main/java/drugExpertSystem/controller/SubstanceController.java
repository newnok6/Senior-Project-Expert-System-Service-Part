package drugExpertSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Panupak on 5/23/2014.
 */
@Controller
@RequestMapping("substancemanagement")
public class SubstanceController {
/*
    @Autowired
    SubstanceService substanceService;
    @Autowired
    SolubilityService solubilityService;
    @Autowired
    KineticReactionService kineticReactionService;

    @Autowired
    DegradationMechanismService degradationMechanismService;

    @Autowired
    PkaService pkaService;

    @Autowired
    PartitionCoefficientService partitionCoefficientService;

    @Autowired
    SolidstateService solidstateService;

    @Autowired
    HygroscopicityService hygroscopicityService;

    @Autowired
    ParticleSizeService particleSizeService;

    @Autowired
    FlowabilityService flowabilityService;

    @Autowired
    DensityService densityService;

    @Autowired
    SaltFormService saltFormService;

    @Autowired
    ABClass abClass;

    @RequestMapping("substanceIndex")
    public String showSubStanceIndex(ModelMap modelMap) {

        modelMap.addAttribute("substanceList", substanceService.getAllSubstance());
        modelMap.addAttribute("solubilityList", solubilityService.getAllSolubility());
        modelMap.addAttribute("kineticReactionList", kineticReactionService.getAllKineticReaction());
        modelMap.addAttribute("degradationMechanismList", degradationMechanismService.getAllDegradationMechanism());
        modelMap.addAttribute("PkaList", pkaService.getAllPka());
        modelMap.addAttribute("partitionCoefficientList", partitionCoefficientService.getAllPartitionCoefficient());
        modelMap.addAttribute("solidstateList", solidstateService.getAllSolidstate());
        modelMap.addAttribute("hygroscopicityList", hygroscopicityService.getAllHygroscopicity());
        modelMap.addAttribute("particleSizeList", particleSizeService.getAllParticleSize());
        modelMap.addAttribute("flowabilityList", flowabilityService.getAllFlowability());
        modelMap.addAttribute("desityList", densityService.getAllDensity());

        return "admin/substanceManagement";
    }


    @RequestMapping(value = "addSubstance", method = RequestMethod.GET)
    public View addSubstance(@ModelAttribute Substance substance, @RequestParam("waterSolubilityId") long waterSoId,
                             @RequestParam("kineticCrId") long kineticId,
                             @RequestParam(value = "degraId") long[] degraId,
                             @RequestParam("disProId") long disProId,
                             @RequestParam("partCoId") long partCoId,
                             @RequestParam("phyId") long phyId,
                             @RequestParam("hygroId") long hygroId,
                             @RequestParam("particleId") long particleId,
                             @RequestParam("alcoholId") long alcoholId,
                             @RequestParam("flowablityId") long flowabilityId,
                             @RequestParam("desityId") long desityId,
                             @RequestParam("molecularWeight") float molecularWeight,
                             @RequestParam("pkaPro") long pkaPro)
                             throws IllegalAccessException, InstantiationException {

        List<DegradationMechanism> degradationMechanismList = new ArrayList<DegradationMechanism>();
        for (long degra : degraId){
            degradationMechanismList.add(degradationMechanismService.getDegradationMechanism(degra));

        }

        Stability stability = new Stability();
        stability.setDegradationMechanismList(degradationMechanismList);
        stability.setKineticreaction(kineticReactionService.getKineticReaction(kineticId));

        SaltForm saltForm = new SaltForm();
        saltForm.setMolecularweightproperty(molecularWeight);
        saltForm.setPkaproperty(pkaService.getPka(pkaPro));

        substance.setWatersolubilityproperty(solubilityService.getSolubility(waterSoId));
        substance.setStabilityproperty(stability);
        substance.setDissolutionproperty(pkaService.getPka(disProId));
        substance.setPartitioncoefficientproperty(partitionCoefficientService.getPartitionCoefficient(partCoId));
        substance.setPhysicalformproperty(solidstateService.getSolidstate(phyId));
        substance.setHygroscopicityproperty(hygroscopicityService.getHygroscopicity(hygroId));
        substance.setParticleproperty(particleSizeService.getParticleSize(particleId));
        substance.setAlcoholsolubilityproperty(solubilityService.getSolubility(alcoholId));
        substance.setFlowabilityproperty(flowabilityService.getFlowability(flowabilityId));
        substance.setPowderdensityproperty(densityService.getDensity(desityId));
        substance.setSaltproperty(saltForm);


        substanceService.addSubstance(substance);
        return new RedirectView("substanceIndex");
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ModelAndView updateAction(ModelAndView model,
                                     @ModelAttribute("substance") Substance substance) throws ParseException {
        System.out.println(substance.getDissolutionproperty().getType());
        return null;
    }
    */
}
