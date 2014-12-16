package drugExpertSystem.InferenceEngine.CaseBaseReasoningEngine;

import drugExpertSystem.InferenceEngine.CaseBaseReasoningEngine.SolAndDisc.SolAndDesc;
import drugExpertSystem.InferenceEngine.InferenceEngineCreator;
import drugExpertSystem.Production.DFProperties.DFProperty;
import drugExpertSystem.Production.Production;

import drugExpertSystem.Production.ProductionService;
import drugExpertSystem.Production.UnitOperation.UnitOperation;
import drugExpertSystem.ReformulationSetting.ReformulationSetting;
import drugExpertSystem.excipient.Excipient;
import drugExpertSystem.formulation.Repository.FormulationRepository;
import jcolibri.casebase.LinealCaseBase;
import jcolibri.cbraplications.StandardCBRApplication;
import jcolibri.cbrcore.Attribute;
import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CBRCaseBase;
import jcolibri.cbrcore.CBRQuery;
import jcolibri.connector.GenericDrugConnector;
import jcolibri.examples.genericDrug.GenericDescription;
import jcolibri.examples.genericDrug.GenericDrugSolution;
import jcolibri.exception.ExecutionException;
import jcolibri.method.retrieve.NNretrieval.NNConfig;
import jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import jcolibri.method.retrieve.NNretrieval.similarity.LocalSimilarityFunction;
import jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import jcolibri.method.retrieve.NNretrieval.similarity.local.Interval;
import jcolibri.method.retrieve.RetrievalResult;
import jcolibri.method.retrieve.selection.SelectCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Panupak on 10/7/2014.
 */

public class CasebaseReasoningEngine implements InferenceEngineCreator,StandardCBRApplication {

    private ReformulationSetting reformulationSetting;
    private List<Production> baseProduction;
    GenericDrugConnector _connector;
    private CBRCaseBase _caseBase;

    @Autowired
    FormulationRepository formulationRepository;
    @Autowired
    ProductionService productionService;


    @Override
    public List<Production> setProductionsFromDB(List<Production> productions) {

        baseProduction = productions;
        return baseProduction;
    }

    @Override
    public ReformulationSetting addReformulateData(ReformulationSetting reformulationSetting) {

       this.reformulationSetting = reformulationSetting;
       return reformulationSetting;
    }

    @Override
    public Production getReformulateResult() {
        Production production = new Production();

            System.out.println(reformulationSetting.getSimilarlityWeight().keySet());

        _connector =  new GenericDrugConnector();
        /// Production production = new Production();
        //production.setFormulationName(caseBaseproduction.getFormulationName());
        //production.setFormulationWeight(caseBaseproduction.getFormulationWeight());
        //DFProperty dfProperty = new DFProperty();
        //dfProperty.setDisgradationtime(70);
        //dfProperty.setTotalweight(14);
        //dfProperty.setHardness(90);
        //dfProperty.setDissolutionProfile(caseBaseproduction.getDfProperty().getDissolutionProfile());
        ///production.setDfProperty(dfProperty);
        List<SolAndDesc> solAndDescs = new ArrayList<SolAndDesc>();
//        DFProperty dfProperty =   new DFProperty();
//
//        // Paracetamol Case 1 //
//        Production paracetamalSol1 = new Production();
//        paracetamalSol1.setId("1");
//        paracetamalSol1.setFormulationName("Paracetamol");
//        paracetamalSol1.setInstraction("1. Dry mixing metformin hydrochloride,sodium strach glycolate,microcrystalline cellulose,and corn starch \n " +
//                "                  2. Wet mixing mixture with water until wet \n" +
//                "                  3. Communition with sieve no.14 \n" +
//                "                  4. Drying \n" +
//                "                  5. Comunition with sieve no.18 \n" +
//                "                  6. Dry Mixing mixture and magnesium stearate");
//        SolAndDesc solAndDesc = new SolAndDesc();
//        Production paracetamalDescri1 = new Production();
//        paracetamalDescri1.setId("1");
//        paracetamalDescri1.setFormulationName("Paracetamol");
//        dfProperty =   new DFProperty();
//
//        dfProperty.setDisgradationtime(10);
//        dfProperty.setTotalweight(50.0);
//        paracetamalDescri1.setDfProperty(dfProperty);
//        solAndDesc.setDescription(paracetamalDescri1);
//        solAndDesc.setSolutionProduction(paracetamalSol1);
//        solAndDescs.add(solAndDesc);
//
//        /////////////////////////////////////////
//
//        Production paracetamalSol2 = new Production();
//        paracetamalSol2.setId("2");
//        paracetamalSol2.setFormulationName("Paracetamol");
//        paracetamalSol2.setInstraction("1. Dry mixing metformin hydrochloride,magnesium stearate,microcrystalline cellulose,and corn starch \n " +
//                "                  2. Wet mixing mixture with water until wet \n" +
//                "                  3. Communition with sieve no.17 \n" +
//                "                  4. Drying \n" +
//                "                  5. Comunition with sieve no.12 \n" +
//                "                  6. Dry Mixing mixture and sodium strach glycolate");
//
//
//        solAndDesc = new SolAndDesc();
//        Production paracetamalDescri2 = new Production();
//        paracetamalDescri2.setId("2");
//        paracetamalDescri2.setFormulationName("Paracetamol");
//        dfProperty =   new DFProperty();
//
//        dfProperty.setDisgradationtime(20);
//        dfProperty.setTotalweight(40.0);
//        paracetamalDescri2.setDfProperty(dfProperty);
//        SolAndDesc solAndDesc1 = new SolAndDesc();
//        solAndDesc1.setDescription(paracetamalDescri2);
//        solAndDesc1.setSolutionProduction(paracetamalSol2);
//        solAndDescs.add(solAndDesc1);

        int count = 0;
           for (Production production1 : baseProduction){
               SolAndDesc solAndDesc = new SolAndDesc();
               solAndDesc.setId(production1.getId());
               solAndDesc.setDescription(production1);
               solAndDesc.setSolutionProduction(production1);
               solAndDescs.add(solAndDesc);
               count++;
           }



        for(SolAndDesc solAndDesc2 : solAndDescs){
            System.out.println("Name" + solAndDesc2.getSolutionProduction().getFormulation().getName());

        }


        //SolAndDesc solAndDesc = new SolAndDesc();
        // List<SolAndDesc> solAndDescs = new ArrayList<SolAndDesc>();

        //ReformulationSetting reformulationSetting = new ReformulationSetting();

        //ReformulationSetting reformulationSetting = new ReformulationSetting();
        //Production production = new Production();
        //production.setFormulationName("atovastatinCalcium");
        //DFProperty dfProperty1 = new DFProperty();
        //dfProperty1.setTotalweight(30);
        //dfProperty1.setDisgradationtime(20);
        //production.setDfProperty(dfProperty1);
        //reformulationSetting.setProduction(production);

        List<Production> productions = new ArrayList<Production>();
        try {

            //  _connector =  new GenericDrugConnector();

            _caseBase = new LinealCaseBase();
            _connector.setSolAndDescs(solAndDescs);
            _connector.setFormulationName(reformulationSetting.getInferenceProduction().getSubstance().getName());
            _caseBase.init(_connector);
            java.util.Collection<CBRCase> cases = _caseBase.getCases();

            System.out.println("This is case size " + cases.size());
            try {
                for (CBRCase c : cases) {
                    System.out.println("mskky" + c.toString());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            boolean cont = true;
            //while(cont)
            //{
                //qf.setVisible(true);
                GenericDescription desc = new GenericDescription();
                //	desc.setAccommodation(AccommodationTypes.valueOf((String)this.accommodation.getSelectedItem()));
                //desc.setDuration(this.duration.getNumber().intValue());
                desc.setName(reformulationSetting.getInferenceProduction().getSubstance().getName());
                desc.setUserWeight(reformulationSetting.getInferenceProduction().getAmountOfStength());
                desc.setDisgrationtime(reformulationSetting.getInferenceProduction().getDisintegrationTime());
                //desc.setNumberOfPersons(this.numberOfPersons.getNumber().intValue());
                //	desc.setSize(Size.valueOf((String)this.size.getSelectedItem()));
                //	desc.setPrice(this.price.getNumber().intValue());
                //desc.setRegion(this.region.getSelectedInstance());
                //desc.setSeason(Seasons.valueOf((String)this.season.getSelectedItem()));
                //desc.setTransportation((String)this.transportation.getSelectedItem());

                CBRQuery query = new CBRQuery();
                query.setDescription(desc);
                NNConfig config = new NNConfig();
                Attribute attribute;
              ///  attribute = new Attribute("name",GenericDescription.class);
               /// LocalSimilarityFunction function;



                // simConfig.setDescriptionSimFunction(new Average());
                attribute = new Attribute("name",GenericDescription.class);
            LocalSimilarityFunction    function =     new Equal();
                config.addMapping(attribute, function);
                for(String key : reformulationSetting.getSimilarlityWeight().keySet()){
                    System.out.println("activeIngredientName");
                    if(key.equals("activeIngredientName")) {
                        System.out.println();
                        config.setWeight(attribute, reformulationSetting.getSimilarlityWeight().get(key));
                        break;
                    }
                }


                attribute = new Attribute("userWeight",GenericDescription.class);
            LocalSimilarityFunction   function1 =  new Interval(10);
                config.addMapping(attribute, function1);
                for(String key : reformulationSetting.getSimilarlityWeight().keySet()){
                    System.out.println("totalWeight");
                    if(key.equals("totalWeight")) {
                        System.out.println("toInside");
                        config.setWeight(attribute, reformulationSetting.getSimilarlityWeight().get(key));
                        break;
                    }
                }

                attribute = new Attribute("disgrationtime",GenericDescription.class);
            LocalSimilarityFunction   function2=  new   Interval(10);
                config.addMapping(attribute, function2);
                for(String key : reformulationSetting.getSimilarlityWeight().keySet()) {
                    System.out.println("distime");
                    if (key.equals("distime")){

                        config.setWeight(attribute, reformulationSetting.getSimilarlityWeight().get(key));
                    break;
                }
                }

                NNConfig simConfig = config;
                simConfig.setDescriptionSimFunction(new Average());



                // Execute NN
                Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);

                // Select k cases
                Collection<CBRCase> selectedcases = SelectCases.selectTopK(eval, 1);
                ArrayList<RetrievalResult>   caseList = new ArrayList<RetrievalResult>();
                //   ArrayList<Integer>    currentCases  =     new     ArrayList<Integer>();
                //  int currentCase=0;
                for(RetrievalResult rr: eval){
                    System.out.println("God Like");
                    if(selectedcases.contains(rr.get_case()))
                    {
                        //currentCases.add(currentCase);
                        caseList.add(rr);

                    }

                }
                for(int i=0;i<caseList.size();i++){
                    try {
                        RetrievalResult rr = caseList.get(i);
                        CBRCase _case = rr.get_case();
                        GenericDescription _desc = (GenericDescription) _case.getDescription();
                        GenericDrugSolution sol = (GenericDrugSolution) _case.getSolution();
                        // sol.getProduction().setFormulationWeight(reformulationSetting.getProduction().getFormulationWeight());
                        productions.add(sol.getProduction());
                        System.out.println("Production dis time " + sol.getProduction().getDistegretionTime());
                    }catch (Exception e1){
                        e1.printStackTrace();
                    }
                }

            for (Production production1 : productions){
                System.out.println(production1.getFormulationName());
                System.out.println(production1.getInstraction());
            }
                ///     CBRQuery query = .getQuery();

                //n.cycle(query);
                //int ans = javax.swing.JOptionPane.showConfirmDialog(null, "CBR cycle finished, query again?", "Cycle finished", javax.swing.JOptionPane.YES_NO_OPTION);
                //cont = (ans == javax.swing.JOptionPane.YES_OPTION);
         //   }
            // n.postCycle();



            // Create the dialogs
            //  similarityDialog = new SimilarityDialog(main);
            // resultDialog     = new ResultDialog(main);
            //autoAdaptDialog  = new AutoAdaptationDialog(main);
            //revisionDialog   = new RevisionDialog(main);
            //retainDialog     = new RetainDialog(main);




        } catch (Exception e) {
            try {
                throw new ExecutionException(e);
            } catch (ExecutionException e1) {
                e1.printStackTrace();
            }
        }


        production = productions.get(0);
        production.setInstraction(this.setInstruction(production));

        return production;

        //return null;
    }

    @Override
    public void configure() throws ExecutionException {
        try {

            _connector =  new GenericDrugConnector();

            _caseBase = new LinealCaseBase();




            // Create the dialogs
            //  similarityDialog = new SimilarityDialog(main);
            // resultDialog     = new ResultDialog(main);
            //autoAdaptDialog  = new AutoAdaptationDialog(main);
            //revisionDialog   = new RevisionDialog(main);
            //retainDialog     = new RetainDialog(main);

        } catch (Exception e) {
            throw new ExecutionException(e);
        }
    }

    @Override
    public CBRCaseBase preCycle() throws ExecutionException {
        _caseBase.init(_connector);
        // Print the cases
        java.util.Collection<CBRCase> cases = _caseBase.getCases();
        for(CBRCase c: cases)
            System.out.println("mskky"+c);
        return _caseBase;

    }

    @Override
    public void cycle(CBRQuery query) throws ExecutionException {

    }

    @Override
    public void postCycle() throws ExecutionException {

    }


    public String setInstruction(Production production){
        StringBuilder instructionBuilder = new StringBuilder();
        instructionBuilder.append("Process : " + " "+ production.getPharmaceuticalProcess().getName()+"\n");
        instructionBuilder.append("Manufacturing :");

        int countOrder = 1;
        for(UnitOperation unitOperation : production.getPharmaceuticalProcess().getUnitOperations()){
                instructionBuilder.append("\n"+countOrder+ " "+unitOperation.getName()+ " ");
                if(unitOperation.getExcipients().size()!=0) {
                    instructionBuilder.append(">");
                    for (Excipient excipient1 : production.getFormulation().getExcipient()) {
                        instructionBuilder.append(" " + excipient1.getSubstance().getName());
                    }
                }else{
                    instructionBuilder.append(" ");
                }
            countOrder++;
            }

        return instructionBuilder.toString();
    }





}

