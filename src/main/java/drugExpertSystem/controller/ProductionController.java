package drugExpertSystem.controller;

import drugExpertSystem.Production.Production;
import drugExpertSystem.Production.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Panupak on 12/6/2014.
 */
@RestController
@RequestMapping("/production")
public class ProductionController {
    @Autowired
    ProductionService productionService;


    @RequestMapping(value = "/add-production",method = RequestMethod.POST)
    public @ResponseBody
    List<Production> addProduction(@RequestBody Production production){
        productionService.createProduction(production);
        return productionService.getAllProduction();
        //System.out.println("Substance adding sucessful");
    }

    @RequestMapping(value = "/update-production",method = RequestMethod.PUT)
    public void updateProduction(@RequestBody Production production){

        productionService.updateProduction(production);
    }

    @RequestMapping(value = "/delete-production/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody void deleteProduction(@PathVariable("id") String id){
        productionService.removeProduction(id);
    }

    @RequestMapping(value = "/productionList.json",method = RequestMethod.GET)
    public @ResponseBody List<Production> getAllProduction()
    {
        return productionService.getAllProduction();
    }
}
