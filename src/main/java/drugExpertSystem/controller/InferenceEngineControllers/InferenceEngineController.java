package drugExpertSystem.controller.InferenceEngineControllers;

import drugExpertSystem.InferenceEngine.InferenceEngineDirector;
import drugExpertSystem.InferenceProduction.InferenceProduction;
import drugExpertSystem.Jess.JessService;

import drugExpertSystem.Production.Production;
import drugExpertSystem.ReformulatedProduction.ReformulatedProduction;
import drugExpertSystem.ReformulationSetting.ReformulationSetting;
import drugExpertSystem.controller.ReformulatedHistory.ReformulatedHistoryController;
import jess.JessException;
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
    InferenceEngineDirector inferenceEngineDirector;

    @RequestMapping(value = "/reformulate-production",method = RequestMethod.POST)
    public @ResponseBody List<ReformulatedProduction> reformulateProduction(@RequestBody ReformulationSetting reformulationSetting){
        try {
            return inferenceEngineDirector.getReformulateResult(reformulationSetting);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;



        // jessService.addBaseFact();
        //System.out.println("Remulate Production has been making");

    }

}
