package drugExpertSystem;

/*
import drugExpertSystem.substance.Entity.SubstanceFunction.BiderFunction;
import drugExpertSystem.substance.Entity.SubstanceFunction.CompoundFunction;
import drugExpertSystem.substance.Substance;
import drugExpertSystem.substance.Service.substanceService.SubstanceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
*/

import drugExpertSystem.InferenceEngine.CaseBaseReasoningEngine.SolAndDisc.SolAndDesc;
import drugExpertSystem.Jess.JessServiceImpl;
import drugExpertSystem.Production.DFProperties.DFProperty;
import drugExpertSystem.Production.Production;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Panupak on 6/27/2014.
 */

public class main {
    public static void main (String[] args ){
        /*
        Array[ ] drug = new Array[5];
         ArrayList<String> catalogue= new ArrayList<String>();
        catalogue.add("metformin hydrochloride");
        catalogue.add("sodium starch glycolate");
        catalogue.add("microcrystaline celluose");
        catalogue.add("maganesium stearate");
        catalogue.add("corn starch");

        ArrayList<String> list1 = new ArrayList<String>();;
         ArrayList<Integer> ceck = new ArrayList<Integer>();
       Random randomGenerator = new Random();
        ArrayList<Integer>  lista = new ArrayList<Integer>();
        lista.add(0);
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        Collections.shuffle(lista);
        System.out.println(lista.get(0));
      ///  for(int i=0;i<catalogue.size();){

       ///     int index = (int)(Math.random()*(catalogue.size()-1));

          //  for(int x=0;x<ceck.size();x++){

             ///   if(ceck.get(x)==index){

                 //   //list1.add(catalogue.get(index));
                //    //i++;
               //     break;
              //  }
             ///   if(x==ceck.size()-1){

                //    list1.add(catalogue.get(index));
                  ///  ceck.add(index);
                  //  i++;

            //    }

          //  }
   //     }

        //Item item = catalogue.get(index);

       for (int i =0 ;i<100;i++){
           DFProperty dfProperty ;
           Collections.shuffle(lista);
           // Paracetamol Case 1 //
           System.out.println(" paracetamalSol"+(i+1) +"= new Production();");
           int r = (int) ((Math.random()+1)*40);
           int r1 = (int) ((Math.random()+1)*40);
           System.out.println("paracetamalSol"+(i+1)+".setFormulationName(\""+"Paracetamol\""+");");
         System.out.println( "paracetamalSol1"+(i+1)+".setInstraction(\""+"1. Dry mixing "+catalogue.get(lista.get(0))+","+catalogue.get(lista.get(1))+","+catalogue.get(lista.get(2))+", and " +catalogue.get(lista.get(3))+" \n " +
                 "                  2. Wet mixing mixture with water until wet \n" +
                 "                  3. Communition with sieve no."+r+" \n" +
                 "                  4. Drying \n" +
                 "                  5. Comunition with sieve no." +r1+
                 "                  6. Dry Mixing mixture and "+ catalogue.get(4)+"  )");

           System.out.println(" solAndDesc = new SolAndDesc();");
           System.out.println(" paracetamalDescri = new Production();");
           System.out.println("paracetamalDescri.setId(\""+(i+1)+");");
           System.out.println("paracetamalDescri1.setFormulationName(\"Paracetamol\");");
           System.out.println(" dfProperty =   new DFProperty();");
           int n = (int) ((Math.random()+1)*300);
           int n1 = (int) ((Math.random()+1)*300);
           System.out.println( "dfProperty.setDisgradationtime("+n+");");
           System.out.println( "dfProperty.setTotalweight("+n1+");");
           System.out.println("paracetamalDescri.setDfProperty(dfProperty);" );
           System.out.println("solAndDesc.setDescription(paracetamalDescri);" );
           System.out.println("solAndDesc.setDescription(paracetamalSol);" );
           System.out.println("solAndDescs.add(solAndDesc);" );
           System.out.println();
           System.out.println();
           System.out.println();
         /*paracetamalSol1.setId("1");qmulationName("Paracetamol");
           paracetamalSol1.setInstraction("1. Dry mixing metformin hydrochloride,sodium strach glycolate,microcrystalline cellulose,and corn starch \n " +
                   "                  2. Wet mixing mixture with water until wet \n" +
                   "                  3. Communition with sieve no.14 \n" +
                   "                  4. Drying \n" +
                   "                  5. Comunition with sieve no.18" +
                   "                  6. Dry Mixing mixture and magnesium stearate")
           SolAndDesc solAndDesc = new SolAndDesc();
           Production paracetamalDescri1 = new Production();
           paracetamalDescri1.setId("1");
           paracetamalDescri1.setFormulationName("Paracetamol");
           dfProperty =   new DFProperty();
           dfProperty.setDisgradationtime(10);
           dfProperty.setTotalweight(50.0);
           paracetamalDescri1.setDfProperty(dfProperty);
           solAndDesc.setDescription(paracetamalDescri1);
           //solAndDesc.setSolutionProduction(paracetamalSol1);
           //solAndDescs.add(solAndDesc);
*/



    //   }




    }
}
