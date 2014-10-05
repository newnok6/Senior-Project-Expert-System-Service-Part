package drugExpertSystem;

/*
import drugExpertSystem.substance.Entity.SubstanceFunction.BiderFunction;
import drugExpertSystem.substance.Entity.SubstanceFunction.CompoundFunction;
import drugExpertSystem.Model.Substance;
import drugExpertSystem.substance.Service.substanceService.SubstanceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
*/

import drugExpertSystem.Jess.JessServiceImpl;

/**
 * Created by Panupak on 6/27/2014.
 */

public class main {
    public static void main (String[] args ){

        JessServiceImpl jessService = new JessServiceImpl();
        jessService.addBaseFact();

    }
}
