package drugExpertSystem.controller.InferenceEngineControllers;

import drugExpertSystem.InferenceEngine.InferenceEngineDirector;
import drugExpertSystem.Jess.JessService;

import drugExpertSystem.Production.Production;
import drugExpertSystem.ReformulateProduction.ReformulatedProduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Panupak on 10/2/2014.
 */
@RestController
@RequestMapping("/inference-engine")
public class InferenceEngineController {
    @Autowired
    JessService jessService;

    @Autowired
    InferenceEngineDirector inferenceEngineDirector;

    @RequestMapping(value = "/reformulate-production",method = RequestMethod.POST)
    public @ResponseBody List<ReformulatedProduction> reformulateProduction(@RequestBody Production production){
        try {
            inferenceEngineDirector.getReformulateResult(production);
        }catch (Exception e){
            e.printStackTrace();
        }

        return inferenceEngineDirector.getReformulateResult(production);



        // jessService.addBaseFact();
        //System.out.println("Remulate Production has been making");

    }

}
