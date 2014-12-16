package drugExpertSystem.InferenceEngine.RuleBaseEngine;

import drugExpertSystem.InferenceProduction.InferenceProduction;
import drugExpertSystem.Production.Process.PharmaceuticalProcess;
import drugExpertSystem.Production.UnitOperation.UnitOperation;
import drugExpertSystem.excipient.Excipient;
import drugExpertSystem.substance.Entity.SubstanceFunction.SubstanceFunction;
import drugExpertSystem.substance.Substance;
import drugExpertSystem.Production.Production;
import drugExpertSystem.ReformulationSetting.ReformulationSetting;
import drugExpertSystem.formulation.Formulation;
import jess.Filter;
import jess.JessException;
import jess.Rete;
import jess.WorkingMemoryMarker;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Panupak on 10/7/2014.
 */
public class RulebaseEngine implements InferenceEngineCreatorForRuleBase{


     private InferenceProduction inferenceProduction;
     private List<Substance> substanceListFormDB;
     private List<Excipient> excipientListFromDB;
     private List<Formulation> formulationListFromDB;
     private List<Production> productionListFromDB;
     private Rete jessEngine;
     private WorkingMemoryMarker marker;

    @Override
    public List<Production> setProductionsFromDB (List<Production> productionList) {

        productionListFromDB = productionList;
        return productionListFromDB;
    }

    @Override
    public ReformulationSetting addReformulateData(ReformulationSetting reformulationSetting) {

        this.inferenceProduction = reformulationSetting.getInferenceProduction();
        return reformulationSetting;
    }

    @Override
    public void setSubstanceFromDB(List<Substance> substanceList) {
        this.substanceListFormDB = substanceList;
    }

    @Override
    public void setExcipientFromDB(List<Excipient> excipientList) {
        this.excipientListFromDB = excipientList;
    }

    @Override
    public void setFormulationFromDB(List<Formulation> formulationList) {
        this.formulationListFromDB = formulationList;
    }




    @Override
    public Production getReformulateResult(){
        Production productionByRuleBase = new Production();

        jessEngine = new Rete();

        try {
            jessEngine.reset();
            // Load Drug Expert System Class Template//
            jessEngine.batch("templateFromClass.clp");
            addInferenceProductionFromUser(jessEngine);
            addExcipientFromDB(jessEngine);
            addFormulationFromDB(jessEngine);


            //Run JESS with Pharmaceutical Rule //
            jessEngine.eval("(facts)");

            // load Rule //
            jessEngine.batch("pharmaceuticalRule.clp");

            // Reset And Run Engine
            jessEngine.reset();
            jessEngine.run();
            jessEngine.eval("(facts)");

            showFormulationFromGenericProduction(jessEngine);
            showProcessNameinProduction(jessEngine);

            //for (Production production :this.getProductionFromJESS(jessEngine)){
                //System.out.println(production);
           // }


            productionByRuleBase = this.getProductionFromJESS(jessEngine);
            productionByRuleBase.setInstraction(this.getInstruction(this.getProductionFromJESS(jessEngine)));
            System.out.println(productionByRuleBase.getInstraction());
           // productionByRuleBase.setInstraction(this.getInstruction(this.getProductionFromJESS(jessEngine)));


           // jessEngine.addAll(substanceListFormDB);
           // jessEngine.addAll(excipientListFromDB);
           // jessEngine.addAll(formulationListFromDB);
           // jessEngine.addAll(productionListFromDB);

            // Mark end of catalog data for later
          // marker = jessEngine.mark();
          //  jessEngine.eval("(facts)");
        } catch (JessException e) {
            e.printStackTrace();
        }
        return productionByRuleBase;
    }


    private void addInferenceProductionFromUser(Rete engine) throws JessException{

        //Set Substance for JESS//
        inferenceProduction.getSubstance().setSource("user");
        //Set Substance Function //
        SubstanceFunction apiFunction = new SubstanceFunction();
        apiFunction.setFunctionName("api");
        ArrayList<SubstanceFunction> substanceFunctionList = new ArrayList<>();
        substanceFunctionList.add(apiFunction);


        //Set Excipient//
        Excipient api = new Excipient();
        api.setSubstance(inferenceProduction.getSubstance());
        api.setSource("user");
        api.setSubstanceFunctions(substanceFunctionList);
        api.setUsedWeight(inferenceProduction.getAmountOfStength());
        ArrayList<Excipient> excipients = new ArrayList<>();
        excipients.add(api);

        //Set Production //
        Production originalProduction = new Production();
        originalProduction.setType("original");
        originalProduction.setDistegretionTime(inferenceProduction.getDisintegrationTime());
        originalProduction.setFriability(inferenceProduction.getFriability());
        originalProduction.setDissolutionProfile(inferenceProduction.getDissolutionProfile());

        //Insert Blank Generic production waiting for modifying value //

        Production production = new Production();
        production.setType("generic");

        //init blank Excipient //
        List<Excipient> excipients2 = new ArrayList<>();
        excipients2.add(api);
        for(int i =0;i<=10; i++){
            Excipient excipient = new Excipient();
            Substance substance1 = new Substance();
            engine.add(substance1);
            SubstanceFunction substanceFunction = new SubstanceFunction();
            engine.add(substanceFunction);
            List<SubstanceFunction> substanceFunctionList1 = new ArrayList<>();
            excipient.setSubstanceFunctions(substanceFunctionList1);
            excipient.setSubstance(substance1);
            excipient.setSource("initial");
            excipients2.add(excipient);

        }
        engine.addAll(excipients2);

        //Init Blank Formulation//
        Formulation formulation = new Formulation();
        formulation.setSource("inference");
        formulation.setExcipient(excipients);
        engine.add(formulation);

        production.setFormulation(formulation);
        PharmaceuticalProcess pharmaceuticalProcess = new PharmaceuticalProcess();

        List<UnitOperation> unitOperationList = new ArrayList<>();
        for(int i =1;i<=10;i++){
            UnitOperation unitOperation = new UnitOperation();
            unitOperation.setSequence(i);
            //unitOperation.setExcipients(excipients);
            unitOperationList.add(unitOperation);


        }
        engine.addAll(unitOperationList);
        pharmaceuticalProcess.setUnitOperations(unitOperationList);
        engine.add(pharmaceuticalProcess);
        production.setPharmaceuticalProcess(pharmaceuticalProcess);
        engine.add(production);

        engine.add(formulation);

        engine.add(inferenceProduction.getSubstance());
        engine.add(apiFunction);
        engine.add(api);
        // engine.add(formulation);
        engine.add(originalProduction);
        /////////////////////////////////////////////////////////////////

    }



    public void addExcipientFromDB(Rete engine) throws JessException {

    // Make Excipient //
        for(Excipient excipient1 : excipientListFromDB){
            excipient1.setSource("databaseE");
            excipient1.getSubstance().setSource("database");
            engine.add(excipient1.getSubstance());
            engine.addAll(excipient1.getSubstanceFunctions());
            engine.add(excipient1);
        }

    }

    public void addFormulationFromDB(Rete engine) throws JessException {

        //Insert The formulation from DB //
        for (Formulation formulation : formulationListFromDB) {

            List<Excipient> excipientListForJess = new ArrayList<>();
              for(Excipient excipient1 : formulation.getExcipient()){
                  excipient1.setSource("database");
                  excipient1.getSubstance().setSource("database");
                  engine.add(excipient1.getSubstance());
                  engine.addAll(excipient1.getSubstanceFunctions());
                  for (SubstanceFunction substanceFunction1 : excipient1.getSubstanceFunctions()){
                      Excipient excipientForJESS = excipient1;
                      excipientForJESS.setSubstanceFunction(substanceFunction1);
                      excipientListForJess.add(excipientForJESS);
                  }
              }


            engine.addAll(excipientListForJess);

            formulation.setSource("database");
            formulation.setExcipient(excipientListForJess);
            engine.add(formulation);
        }
    }

    public String getInstruction(Production production){
              StringBuilder instructionBuilder = new StringBuilder();
              instructionBuilder.append("Process : " + " "+ production.getPharmaceuticalProcess().getName()+"\n");
              instructionBuilder.append("Manufacturing :");
              for(UnitOperation unitOperation : production.getPharmaceuticalProcess().getUnitOperations()){
                  if(unitOperation.getName().equals("mixing")){
                      instructionBuilder.append("\n"+unitOperation.getSequence()+ " "+unitOperation.getName()+ " >");
                      for (Excipient excipient1 : production.getFormulation().getExcipient()){
                          instructionBuilder.append(" " +excipient1.getSubstance().getName());
                      }
                  }else{
                      break;
                  }


                  }
            instructionBuilder.append("\n");
            instructionBuilder.append("2 compression");



        return instructionBuilder.toString();
    }

    public Production getProductionFromJESS(Rete engine){
        Production production = new Production();

        // Get Solution From JESS
        Iterator<Production> productions = engine.getObjects(new Filter.ByClass(Production.class));
        while (productions.hasNext()){
            Production production3 = productions.next();
            if(production3.getType().equals("generic")) {
                   production = production3;
                   production.setTotalWeight(inferenceProduction.getTotalWeight());
            }
        }
        return production;
    }


    public void showFormulationFromGenericProduction(Rete engine){

        // Get Solution From JESS
        Iterator<Production> productions = engine.getObjects(new Filter.ByClass(Production.class));

        List<Production> productionList = new ArrayList<>();
        while (productions.hasNext()){
            Production production3 = productions.next();
            if(production3.getType().equals("generic")) {
                for(Excipient excipient : production3.getFormulation().getExcipient()){
                    System.out.println(excipient.getSubstance().getName()+ " " + excipient.getUsedWeight());
                }
                // productionList.add(production3);
            }
        }


    }

    public void showProcessNameinProduction(Rete engine){

        // Get Solution From JESS
        Iterator<Production> productions = engine.getObjects(new Filter.ByClass(Production.class));

        List<Production> productionList = new ArrayList<>();
        while (productions.hasNext()){
            Production production3 = productions.next();
            if(production3.getType().equals("generic")) {
                System.out.println(production3.getPharmaceuticalProcess().getName());
                for (UnitOperation unitOperation : production3.getPharmaceuticalProcess().getUnitOperations()){
                    System.out.println(unitOperation.getSequence()+ " " + unitOperation.getName());
                    if(unitOperation.getExcipients() != null) {
                       // for (Excipient excipient1 : unitOperation.getExcipients()) {
//                      unitOperation.getExcipients()
                         //   System.out.println(excipient1.getSubstance().getName());
                      //  }
                    }
                }
                // productionList.add(production3);
            }
        }


    }


    /*
        Production paracetamal = new Production();
        paracetamal.setFormulationName("paracetamol");
        paracetamal.setInstraction("1. Dry mixing metformin hydrochloride, sodium strach glycolate \n " +
                "                  2. Wet mixing mixture with water until wet \n" +
                "                  3. Communition with sieve no.14 \n" +
                "                  4. Drying \n" +
                "                  5. Comunition with sieve no.18 \n" +
                "                  6. Dry Mixing mixture and magnesium stearate \n");

        Production metforminHydrochloride = new Production();
        metforminHydrochloride.setFormulationName("Metformin hydrochloride");
        metforminHydrochloride.setInstraction("1. Dry mixing metformin hydrochride , provide K30 \n" +
                "                              2. Wet mixing mixture with water until wet \n" +
                "                              3. Communition with sieve no.14 \n" +
                "                              4. Drying \n" +
                "                              5. Communition with sieve no.18 \n" +
                "                              6. Dry mixing mixture and magnesium stearate \n" +
                "                              7. Compression \n");
        Production hydroxyzineHydrohloride = new Production();
        hydroxyzineHydrohloride.setFormulationName("Hydroxyzine Hydrohloride");
        hydroxyzineHydrohloride.setInstraction("1. Dry mixing hydroxyzine hydrochloride, croscarmellose soduim, microcrystalline cellulose and lactose \n" +
                "                              2. Wet mixing mixture with water until wet \n" +
                "                              3. Communition with sieve no.14 \n" +
                "                              4. Drying \n" +
                "                              5. Communition with sieve no.18 \n" +
                "                              6. Dry mixing mixture, colloidal siilicon dioxide and magnesium stearate \n" +
                "                              7. Compression \n");
        Production atorvastatinCalcium = new Production();
        atorvastatinCalcium.setFormulationName("AtorvastatinCalcium");
        atorvastatinCalcium.setInstraction("1. Wet mixing API and solubilzer \n" +
                "                           2. Dry mixing the mixture from 1 with disintegrant,binder, buffering agent and dilluent \n" +
                "                           3. Wet mixing the mixture from 2 with water until wet \n" +
                "                           4. Communition with sieve no.14 \n" +
                "                           5. Drying \n" +
                "                           6. Communition with sive no.18 \n" +
                "                           7. Compression \n");


        Hashtable<String,Production> productions = new Hashtable<>();
        productions.put("Paracetamol",paracetamal);
        productions.put("Metformin hydrochloride",metforminHydrochloride);
        productions.put("Hydroxyzine Hydrohloride",hydroxyzineHydrohloride);
        productions.put("AtorvastatinCalcium",atorvastatinCalcium);

        Production production = productions.get(reformulateproduction.getProduction().getFormulationName());
        production.setFormulationWeight(reformulateproduction.getProduction().getFormulationWeight());
        System.out.println(production.getFormulationName());
        List<Production> productionList = new ArrayList<>();
        productionList.add(production);



        return productionList;
        */


}
