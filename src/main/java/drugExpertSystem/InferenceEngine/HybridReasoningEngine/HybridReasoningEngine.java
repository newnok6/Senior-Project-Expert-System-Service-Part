package drugExpertSystem.InferenceEngine.HybridReasoningEngine;

import drugExpertSystem.InferenceEngine.InferenceEngineCreator;
import drugExpertSystem.InferenceProduction.InferenceProduction;
import drugExpertSystem.Production.Process.PharmaceuticalProcess;
import drugExpertSystem.Production.Production;
import drugExpertSystem.Production.UnitOperation.UnitOperation;
import drugExpertSystem.ReformulationSetting.ReformulationSetting;
import drugExpertSystem.excipient.Excipient;
import drugExpertSystem.formulation.Formulation;
import drugExpertSystem.substance.Entity.SubstanceFunction.SubstanceFunction;
import drugExpertSystem.substance.Substance;
import jess.Filter;
import jess.JessException;
import jess.Rete;
import jess.WorkingMemoryMarker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Panupak on 10/27/2014.
 */
public class HybridReasoningEngine implements InferenceEngineCreatorHybrid{

    private InferenceProduction inferenceProduction;
    private List<Substance> substanceListFormDB;
    private List<Excipient> excipientListFromDB;
    private Formulation formulationFromCaseBase;
    private List<Production> productionListFromDB;

    private Rete jessEngine;
    private WorkingMemoryMarker marker;

    @Override
    public List<Production> setProductionsFromDB(List<Production> productions) {
        this.productionListFromDB = productions;
        return productionListFromDB;
    }

    @Override
    public ReformulationSetting addReformulateData(ReformulationSetting reformulationSetting) {
        this.inferenceProduction = reformulationSetting.getInferenceProduction();
        return null;
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
    public void setFormulationFromCaseBase(Formulation formulation) {
            this.formulationFromCaseBase = formulation;
    }

    @Override
    public Production getReformulateResult() {

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

    private void addInferenceProductionFromUser(Rete engine) throws JessException {

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
        //Insert Fact For Test instead from database //
          List<Excipient> excipientListForJess = new ArrayList<>();
          for(Excipient excipient1 : formulationFromCaseBase.getExcipient()){
              excipient1.setSource("database");
              excipient1.getSubstance().setSource("database");
              engine.add(excipient1.getSubstance());
              engine.addAll(excipient1.getSubstanceFunctions());

              for(SubstanceFunction substanceFunction : excipient1.getSubstanceFunctions()){
                  Excipient excipientForJess = excipient1;
                  excipientForJess.setSubstanceFunction(substanceFunction);
                  excipientListForJess.add(excipientForJess);
              }
          }

           engine.addAll(excipientListForJess);
           formulationFromCaseBase.setSource("database");
           formulationFromCaseBase.setExcipient(excipientListForJess);
           engine.add(formulationFromCaseBase);


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


}
