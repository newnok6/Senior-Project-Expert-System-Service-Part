package drugExpertSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Panupak on 5/31/2014.
 */
@Controller
@RequestMapping("/")
public class AdminController {

    @RequestMapping
    public String callHomePage() {

        return "adminhome";
    }

}
