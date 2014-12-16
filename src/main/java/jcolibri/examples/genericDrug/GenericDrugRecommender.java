package jcolibri.examples.genericDrug;

import drugExpertSystem.Production.Production;
import drugExpertSystem.main;
import drugExpertSystem.substance.Entity.SubstanceFunction.BinderFunction;
import jcolibri.casebase.LinealCaseBase;
import jcolibri.cbraplications.StandardCBRApplication;
import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CBRCaseBase;
import jcolibri.cbrcore.CBRQuery;
import jcolibri.cbrcore.Connector;
import jcolibri.connector.GenericDrugConnector;
import jcolibri.examples.genericDrug.gui.*;
import jcolibri.exception.ExecutionException;
import jcolibri.method.retrieve.NNretrieval.NNConfig;
import jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import jcolibri.method.retrieve.RetrievalResult;
import jcolibri.method.retrieve.selection.SelectCases;
import jcolibri.method.reuse.NumericDirectProportionMethod;
import jcolibri.cbrcore.Attribute;
import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by COMPAQ on 7/11/2557.
 */
public class GenericDrugRecommender implements StandardCBRApplication  {
    private Production caseBaseproduction;
    private List<Production> baseProduction;
    Connector _connector;
    CBRCaseBase _caseBase;
    SimilarityDialog similarityDialog;
    ResultDialog resultDialog;
    AutoAdaptationDialog autoAdaptDialog;
    RevisionDialog revisionDialog;
    RetainDialog retainDialog;
    @Override
    public void configure() throws ExecutionException {
        _connector =  new GenericDrugConnector();

        _caseBase = new LinealCaseBase();
    }

    @Override
    public CBRCaseBase preCycle() throws ExecutionException {
        _caseBase.init(_connector);
        // Print the cases
        Collection<CBRCase> cases = _caseBase.getCases();
        for(CBRCase c: cases)
            System.out.println("mskky"+c);
        return _caseBase;
    }

    @Override
    public void cycle(CBRQuery query) throws ExecutionException {
        similarityDialog.setVisible(true);
        NNConfig simConfig = similarityDialog.getSimilarityConfig();
        simConfig.setDescriptionSimFunction(new Average());

        // Execute NN
        Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);

        // Select k cases
        Collection<CBRCase> selectedcases = SelectCases.selectTopK(eval, similarityDialog.getK());

        // Show result
        resultDialog.showCases(eval, selectedcases);
        resultDialog.setVisible(true);

        // Show adaptation dialog
        autoAdaptDialog.setVisible(true);

        // Adapt depending on user selection
        if(autoAdaptDialog.adapt_Duration_Price())
        {
            // Compute a direct proportion between the "Duration" and "Price" attributes.
            NumericDirectProportionMethod.directProportion(new Attribute("typeOfpizza", GenericDrugRecommender.class),
                    new Attribute("pizza",GenericDrugSolution.class),
                    query, selectedcases);
        }

        if(autoAdaptDialog.adapt_NumberOfPersons_Price())
        {
            // Compute a direct proportion between the "Duration" and "Price" attributes.
            NumericDirectProportionMethod.directProportion(	new Attribute("numberOfPersons",GenericDescription.class),
                    new Attribute("pizza",GenericDrugSolution.class),
                    query, selectedcases);
        }

        // Revise
        revisionDialog.showCases(selectedcases);
        revisionDialog.setVisible(true);

        // Retain
        retainDialog.showCases(selectedcases, _caseBase.getCases().size());
        retainDialog.setVisible(true);
        Collection<CBRCase> casesToRetain = retainDialog.getCasestoRetain();
        _caseBase.learnCases(casesToRetain);
    }

    @Override
    public void postCycle() throws ExecutionException {

    }
    public static void main(String[] args) {

        GenericDrugRecommender n = new GenericDrugRecommender();
        try {
            n.configure();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
         n.showMainFrame();
        BinderFunction binderFunction;
        try {

            n.configure();
            n.preCycle();

            QueryDialog qf = new QueryDialog(main);
            boolean cont = true;
            while(cont)
            {
                qf.setVisible(true);
                CBRQuery query = qf.getQuery();

                n.cycle(query);
                int ans = JOptionPane.showConfirmDialog(null, "CBR cycle finished, query again?", "Cycle finished", JOptionPane.YES_NO_OPTION);
                cont = (ans == JOptionPane.YES_OPTION);
            }
            n.postCycle();


        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    static JFrame main;
    void showMainFrame()
    {
        main = new JFrame("Travel Recommender");
        main.setResizable(false);
        main.setUndecorated(true);
        JLabel label = new JLabel(new ImageIcon(jcolibri.util.FileIO.findFile("/jcolibri/test/main/jcolibri2.jpg")));
        main.getContentPane().add(label);
        main.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        main.setBounds((screenSize.width - main.getWidth()) / 2,
                (screenSize.height - main.getHeight()) / 2,
                main.getWidth(),
                main.getHeight());
        main.setVisible(true);
    }



}
