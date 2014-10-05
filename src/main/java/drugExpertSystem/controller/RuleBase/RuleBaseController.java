package drugExpertSystem.controller.RuleBase;

import drugExpertSystem.Jess.JessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Panupak on 10/2/2014.
 */
@RestController
@RequestMapping("/rule-base")
public class RuleBaseController {
    @Autowired
    JessService jessService;

    @RequestMapping(value = "/testjess",method = RequestMethod.POST)
    public void addSubstance(){
        jessService.addBaseFact();
        System.out.println("Excipient adding sucessful");
    }

}
