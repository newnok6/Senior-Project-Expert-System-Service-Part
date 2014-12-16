package jcolibri.examples.Pizza;

import
        java.awt.Dimension;
import java.util.ArrayList;




import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import drugExpertSystem.substance.Entity.SubstanceFunction.BinderFunction;
import es.ucm.fdi.gaia.ontobridge.OntoBridge;
import es.ucm.fdi.gaia.ontobridge.OntologyDocument;
import jcolibri.casebase.LinealCaseBase;
import jcolibri.cbraplications.StandardCBRApplication;
import jcolibri.cbrcore.Attribute;
import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CBRCaseBase;
import jcolibri.cbrcore.CBRQuery;
import jcolibri.cbrcore.Connector;
import jcolibri.connector.DataBaseConnector;
import jcolibri.connector.*;
import jcolibri.examples.Pizza.gui.AutoAdaptationDialog;
import jcolibri.examples.Pizza.gui.QueryDialog;
import jcolibri.examples.Pizza.gui.ResultDialog;
import jcolibri.examples.Pizza.gui.RetainDialog;
import jcolibri.examples.Pizza.gui.RevisionDialog;
import jcolibri.examples.Pizza.gui.SimilarityDialog;
import jcolibri.examples.TravelRecommender.TravelDescription;
import jcolibri.examples.TravelRecommender.TravelSolution;
import jcolibri.exception.ExecutionException;
import jcolibri.method.retrieve.RetrievalResult;
import jcolibri.method.retrieve.NNretrieval.NNConfig;
import jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import jcolibri.method.retrieve.selection.SelectCases;
import jcolibri.method.reuse.NumericDirectProportionMethod;
import jcolibri.util.FileIO;

public class PizzaRecommender implements StandardCBRApplication {


	private static PizzaRecommender _instance = null;
	public  static PizzaRecommender getInstance()
	{
		if(_instance == null)
		   _instance = new PizzaRecommender();
		return _instance;
	}
	
	private PizzaRecommender()
	{
		
	}
	
	/** Connector object */
	Connector _connector;
	/** CaseBase object */
	CBRCaseBase _caseBase;
	
	SimilarityDialog similarityDialog;
	ResultDialog resultDialog;
	AutoAdaptationDialog autoAdaptDialog;
	RevisionDialog revisionDialog;
	RetainDialog retainDialog;
	
	
	@Override
	public void configure() throws ExecutionException {
		// TODO Auto-generated method stub
		try {
			//Emulate data base server
			//jcolibri.test.database.HSQLDBserver.init();
			
			// Create a data base connector
		_connector =  new pizzabaseDataConnector();
			// Init the ddbb connector with the config file
		///	_connector.initFromXMLfile(jcolibri.util.FileIO
			//.findFile("jcolibri/examples/Pizza/databaseconfig.xml"));
			// Create a Lineal case base for in-memory organization
			_caseBase = new LinealCaseBase();
			
			
			

			// Create the dialogs
		similarityDialog = new SimilarityDialog(main);
			resultDialog     = new ResultDialog(main);
			autoAdaptDialog  = new AutoAdaptationDialog(main);
			revisionDialog   = new RevisionDialog(main);
			retainDialog     = new RetainDialog(main);
			
		} catch (Exception e) {
			throw new ExecutionException(e);
		}
		
	}

	@Override
	public CBRCaseBase preCycle() throws ExecutionException {
		// TODO Auto-generated method stub
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
			NumericDirectProportionMethod.directProportion(	new Attribute("typeOfpizza",PizzaDescription.class), 
				 											new Attribute("pizza",PizzaSolution.class), 
				 											query, selectedcases);
		}
		
		if(autoAdaptDialog.adapt_NumberOfPersons_Price())
		{
			// Compute a direct proportion between the "Duration" and "Price" attributes.
			NumericDirectProportionMethod.directProportion(	new Attribute("numberOfPersons",PizzaDescription.class), 
				 											new Attribute("pizza",PizzaSolution.class), 
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
		// TODO Auto-generated method stub
		
	}

	static JFrame main;
	void showMainFrame()
	{
		main = new JFrame("Travel Recommender");
		main.setResizable(false);
		main.setUndecorated(true);
		JLabel label = new JLabel(new ImageIcon(FileIO.findFile("/jcolibri/test/main/jcolibri2.jpg")));
		main.getContentPane().add(label);
		main.pack();
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		main.setBounds((screenSize.width - main.getWidth()) / 2,
			(screenSize.height - main.getHeight()) / 2, 
			main.getWidth(),
			main.getHeight());
		main.setVisible(true);
	}
	
	
	
	
	public static void main(String[] args) {
	
	PizzaRecommender n = new PizzaRecommender();
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
					int ans = javax.swing.JOptionPane.showConfirmDialog(null, "CBR cycle finished, query again?", "Cycle finished", javax.swing.JOptionPane.YES_NO_OPTION);
					cont = (ans == javax.swing.JOptionPane.YES_OPTION);
				}
				n.postCycle();
				
			
	} catch (ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
