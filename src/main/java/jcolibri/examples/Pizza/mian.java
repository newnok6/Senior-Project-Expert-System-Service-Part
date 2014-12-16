package jcolibri.examples.Pizza;

import java.util.ArrayList;

import antlr.collections.List;
import drugExpertSystem.main;
import jcolibri.casebase.LinealCaseBase;
import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CBRCaseBase;
import jcolibri.cbrcore.CaseComponent;
import jcolibri.cbrcore.Connector;
import jcolibri.connector.DataBaseConnector;
import jcolibri.connector.pizzabaseDataConnector;
import jcolibri.exception.AttributeAccessException;
import jcolibri.exception.InitializingException;
import jcolibri.exception.NoApplicableSimilarityFunctionException;
import jcolibri.method.retrieve.NNretrieval.similarity.local.Interval;

public class mian {
  Double m =4.7;




	public static void main(String[] args)  {
		CBRCaseBase _caseBase;
		_caseBase = new LinealCaseBase();
		Connector p = new pizzabaseDataConnector();
//p.retrieveAllCases();
        main main = new main();
        Number d=6.7;
        Double m =4.7;
        Interval interval = new Interval(m);
        try {
            interval.compute(m,m);
        } catch (NoApplicableSimilarityFunctionException e) {
            e.printStackTrace();
        }


    }
	

}
