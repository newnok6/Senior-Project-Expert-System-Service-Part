package jcolibri.connector;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CaseBaseFilter;
import jcolibri.cbrcore.CaseComponent;
import jcolibri.cbrcore.Connector;
import jcolibri.examples.Pizza.PizzaDescription;
import jcolibri.examples.Pizza.PizzaSolution;
import jcolibri.exception.AttributeAccessException;
import jcolibri.exception.InitializingException;

public class pizzabaseDataConnector implements Connector{
	private String descriptionClassName;
	private String solutionClassName;
	private String justOfSolutionClassName;
	private String resultClassName;
	@Override
	public void initFromXMLfile(URL file) throws InitializingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storeCases(Collection<CBRCase> cases) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCases(Collection<CBRCase> cases) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<CBRCase> retrieveAllCases() {
		// TODO Auto-generated method stub
		ArrayList<CBRCase> res = new ArrayList<CBRCase>();
		List<PizzaDescription> descList = new ArrayList<PizzaDescription>();
try{
		HashMap<Object, CaseComponent> solList = null;
		HashMap<Object, CaseComponent> justSolList = null;
		HashMap<Object, CaseComponent> resList = null;
		solutionClassName= "eqwe";
		ArrayList<PizzaSolution> solutionList = new ArrayList<PizzaSolution>();
		ArrayList<String> justOfSolution = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		PizzaSolution p1 = new PizzaSolution();
		p1.setId("1");
		p1.setPizza("pizza1");

		solutionList.add(p1);
		PizzaSolution p2 = new PizzaSolution();
		p2.setId("2");
		p2.setPizza("pizza2");
		solutionList.add(p2);
		
		PizzaSolution p3 = new PizzaSolution();
		p3.setId("3");
		p3.setPizza("pizza3");
		solutionList.add(p3);
		PizzaSolution p4 = new PizzaSolution();
		p4.setId("4");
		p4.setPizza("pizza4");
		solutionList.add(p4);
		PizzaSolution p5 = new PizzaSolution();
		p5.setId("5");
		p5.setPizza("pizza5");
		solutionList.add(p5);
		PizzaSolution p6 = new PizzaSolution();
		p6.setId("6");
		p6.setPizza("pizza6");
		solutionList.add(p6);
		//solutionList.add("(1;pizza1)");
		//solutionList.add("(2;pizza2)");
		//solutionList.add("(3;pizza3)");
		//solutionList.add("(4;pizza4)");
		//solutionList.add("(5;pizza5)");
		//solutionList.add("(6;pizza6)");
		
		
		if(solutionClassName != null)
		{
			

			solList = new HashMap<Object, CaseComponent>();
			List l = solutionList;
			for(int i =0;i<l.size();i++){
				System.out.print(solutionList.get(i).toString());
			}
	
			for(int i =0 ;i<l.size();i++ )
			{
				
				CaseComponent cc =(CaseComponent) l.get(i);
				solList.put(cc.getIdAttribute().getValue(cc), cc);
			}
			
			
		}
		
		if(justOfSolutionClassName != null)
		{
			

			justSolList = new HashMap<Object, CaseComponent>();
			List l = justOfSolution;
			

			for(Iterator iter = l.iterator(); iter.hasNext();)
			{
				CaseComponent cc = (CaseComponent)iter.next();
				justSolList.put(cc.getIdAttribute().getValue(cc), cc);
			}
		}
		if(resultClassName != null)
		{
			

			resList = new HashMap<Object, CaseComponent>();
			List l =  result;
			

			for(Iterator iter = l.iterator(); iter.hasNext();)
			{
				CaseComponent cc = (CaseComponent)iter.next();
				resList.put(cc.getIdAttribute().getValue(cc), cc);
			}
			}
		
		PizzaDescription pd1 = new PizzaDescription();
		pd1.setCaseId("1");
		pd1.setNumberOfPersons(1);
		pd1.setTypeOfpizza("ThinandCripy");
	//	pd1.setSize("large");
		//pd1.setPrice(1);
		descList.add(pd1);
		PizzaDescription pd2 = new PizzaDescription();
		pd2.setCaseId("2");
		pd2.setNumberOfPersons(2);
		pd2.setTypeOfpizza("ThinandCripy");
		//pd2.setSize("large");
	//	pd2.setPrice(2);
		descList.add(pd2);
		PizzaDescription pd3 = new PizzaDescription();
		pd3.setCaseId("3");
		pd3.setNumberOfPersons(3);
		pd3.setTypeOfpizza("ThinandCripy");
		//pd3.setSize("medium");
		///pd3.setPrice(1);
		descList.add(pd3);
		PizzaDescription pd4 = new PizzaDescription();
		pd4.setCaseId("4");
		pd4.setNumberOfPersons(1);
		pd4.setTypeOfpizza("DeepPanBase");
		//pd4.setSize("medium");
	//	pd4.setPrice(2);
		descList.add(pd4);
		PizzaDescription pd5 = new PizzaDescription();
		pd5.setCaseId("5");
		pd5.setNumberOfPersons(2);
		pd5.setTypeOfpizza("DeepPanBase");
		//pd5.setSize("small");
		//pd5.setPrice(1);
		descList.add(pd5);
		PizzaDescription pd6 = new PizzaDescription();
		pd6.setCaseId("6");
		pd6.setNumberOfPersons(3);
		pd6.setTypeOfpizza("DeepPanBase");
	//	pd6.setSize("small");
		//pd6.setPrice(2);
		descList.add(pd6);
			//descList.add("(1;ThinandCripy;1");
			//descList.add("(2;ThinandCripy;2");
			//descList.add("(3;ThinandCripy;3");
			//descList.add("(4;DeepPanBase;1");
			//descList.add("(5;DeepPanBase;2");
			//descList.add("(6;DeepPanBase;3");
			for(Iterator iter = descList.iterator(); iter.hasNext();)
			{
				CBRCase _case = new CBRCase();
				CaseComponent desc = (CaseComponent)iter.next();
				_case.setDescription(desc);
				if(solutionClassName != null)
				{
					CaseComponent cc = solList.get(desc.getIdAttribute().getValue(desc));
					if(cc != null)
						_case.setSolution(cc);
				}
				if(justOfSolutionClassName != null)
				{
					CaseComponent cc = justSolList.get(desc.getIdAttribute().getValue(desc));
					if(cc != null)
						_case.setJustificationOfSolution(cc);
				}						
				if(resultClassName != null)
				{
					CaseComponent cc = resList.get(desc.getIdAttribute().getValue(desc));
					if(cc != null)
						_case.setResult(cc);
				}
						
				res.add(_case);
				
				
				
			}
			
		
} catch (Exception e) {
	org.apache.commons.logging.LogFactory.getLog(this.getClass()).error(e);
}
		
return res;
	}

	@Override
	public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
