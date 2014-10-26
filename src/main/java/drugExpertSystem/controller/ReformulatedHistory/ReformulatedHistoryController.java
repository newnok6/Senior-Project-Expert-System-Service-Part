package drugExpertSystem.controller.ReformulatedHistory;


import drugExpertSystem.ReformulationHistory.ReformulationHistory;
import drugExpertSystem.ReformulationHistory.ReformulationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Panupak on 10/11/2014.
 */
@RestController
@RequestMapping("/reformulation-history")
public class ReformulatedHistoryController {
    @Autowired
    ReformulationHistoryService reformulationHistoryService;

    @RequestMapping(value = "/create-reformulation-history",method = RequestMethod.POST)
    public void createReformulationhistory(@RequestBody ReformulationHistory reformulationHistory){
        try {
            reformulationHistoryService.createHistory(reformulationHistory);
            System.out.println("Create the Formulation History Successful");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/update-reformulation-history",method = RequestMethod.PUT)
    public  @ResponseBody
    void updateReformulationHistory(@RequestBody ReformulationHistory reformulationHistory){
       try{
           reformulationHistoryService.updateHistory(reformulationHistory);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    @RequestMapping(value = "/remove-reformulation-history/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody void removeReformulationHistory(@PathVariable("id") String id){
       try{
           reformulationHistoryService.removeHistory(id);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    @RequestMapping(value = "/reformulation-history-list.json",method = RequestMethod.GET)
    public List<ReformulationHistory> getAllReformulatedHistory(){
        return reformulationHistoryService.getAllHistory();
    }
}
