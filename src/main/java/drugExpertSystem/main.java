package drugExpertSystem;


import drugExpertSystem.substance.Entity.SubstanceFunction.BiderFunction;
import drugExpertSystem.substance.Entity.SubstanceFunction.CompoundFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Panupak on 6/27/2014.
 */
public class main {
    public static void main (String[] args ){
        List<CompoundFunction> compoundFunctions = new ArrayList<CompoundFunction>();
       // BiderFunction bider = new BiderFunction(1,"Testing");
        //compoundFunctions.add(bider);

        for(CompoundFunction compoundFunction : compoundFunctions){
            System.out.println(compoundFunction.toString());
        }
    }
}
