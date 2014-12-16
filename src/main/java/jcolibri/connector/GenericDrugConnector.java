package jcolibri.connector;

import drugExpertSystem.InferenceEngine.CaseBaseReasoningEngine.SolAndDisc.SolAndDesc;
import drugExpertSystem.Production.DFProperties.DFProperty;
import drugExpertSystem.Production.Production;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jcolibri.cbrcore.Attribute;
import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CaseBaseFilter;
import jcolibri.cbrcore.CaseComponent;
import jcolibri.cbrcore.Connector;
import jcolibri.examples.genericDrug.GenericDescription;
import jcolibri.examples.genericDrug.GenericDrugSolution;
import jcolibri.exception.InitializingException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GenericDrugConnector
        implements Connector
{
    List<SolAndDesc> solAndDescs;
    private String descriptionClassName;
    private String solutionClassName;
    private String justOfSolutionClassName;
    private String resultClassName;
    private String formulationName;

    public String getFormulationName() {
        return formulationName;
    }

    public void setFormulationName(String formulationName) {
        this.formulationName = formulationName;
    }

    public GenericDrugConnector() {}

    public List<SolAndDesc> getSolAndDescs()
    {
        return this.solAndDescs;
    }

    public void setSolAndDescs(List<SolAndDesc> solAndDescs)
    {
        this.solAndDescs = solAndDescs;
    }

    public void initFromXMLfile(URL file)
            throws InitializingException
    {}

    public void close() {}

    public void storeCases(Collection<CBRCase> cases) {}

    public void deleteCases(Collection<CBRCase> cases) {}

    public Collection<CBRCase> retrieveAllCases()
    {
        ArrayList<CBRCase> res = new ArrayList();
        List<GenericDescription> descList = new ArrayList();
        try
        {
            HashMap<Object, CaseComponent> solList = null;
            HashMap<Object, CaseComponent> justSolList = null;
            HashMap<Object, CaseComponent> resList = null;
            this.solutionClassName = "";
            ArrayList<GenericDrugSolution> solutionList = new ArrayList();
            ArrayList<String> justOfSolution = new ArrayList();
            ArrayList<String> result = new ArrayList();



            for (int i = 0; i < this.solAndDescs.size(); i++)
            {
                if(this.solAndDescs.get(i).getSolutionProduction().getFormulation().getName().toLowerCase().equals(this.formulationName.toLowerCase())) {
                    GenericDrugSolution genericDrugSolution = new GenericDrugSolution();
                    genericDrugSolution.setId(((SolAndDesc) this.solAndDescs.get(i)).getSolutionProduction().getId());
                    genericDrugSolution.setProduction(((SolAndDesc) this.solAndDescs.get(i)).getSolutionProduction());
                    solutionList.add(genericDrugSolution);
                }
            }
            if (this.solutionClassName != null)
            {
                solList = new HashMap();
                List l = solutionList;
                for (int i = 0; i < l.size(); i++) {
                    System.out.print(((GenericDrugSolution)solutionList.get(i)).toString());
                }
                for (int i = 0; i < l.size(); i++)
                {
                    CaseComponent cc = (CaseComponent)l.get(i);
                    solList.put(cc.getIdAttribute().getValue(cc), cc);
                }
            }
            Iterator iter;
            if (this.justOfSolutionClassName != null)
            {
                justSolList = new HashMap();
                List l = justOfSolution;
                for (iter = l.iterator(); iter.hasNext();)
                {
                    CaseComponent cc = (CaseComponent)iter.next();
                    justSolList.put(cc.getIdAttribute().getValue(cc), cc);
                }
            }

            if (this.resultClassName != null)
            {
                resList = new HashMap();
                List l = result;
                for (iter = l.iterator(); iter.hasNext();)
                {
                    CaseComponent cc = (CaseComponent)iter.next();
                    resList.put(cc.getIdAttribute().getValue(cc), cc);
                }
            }
            for (int i = 0; i < this.solAndDescs.size(); i++)
            {
                if(this.solAndDescs.get(i).getDescription().getFormulation().getName().toLowerCase().equals(this.formulationName.toLowerCase())) {
                    GenericDescription genericDescription = new GenericDescription();
                    genericDescription.setCaseId(((SolAndDesc) this.solAndDescs.get(i)).getDescription().getId());
                    System.out.println("GU " + i);
                    genericDescription.setName(((SolAndDesc) this.solAndDescs.get(i)).getDescription().getFormulation().getName());
                    System.out.println("GG " + i);

                    //Update to real use Weight //
                    genericDescription.setUserWeight(6.8);
                    System.out.println("KO " + i);
                    genericDescription.setDisgrationtime(Integer.valueOf(((SolAndDesc) this.solAndDescs.get(i)).getDescription().getDistegretionTime()));
                    System.out.println("FUCk " + i);
                    descList.add(genericDescription);
                    System.out.println("DAM " + i);
                }
            }
            for (iter = descList.iterator(); iter.hasNext();)
            {
                CBRCase _case = new CBRCase();
                CaseComponent desc = (CaseComponent)iter.next();
                _case.setDescription(desc);
                if (this.solutionClassName != null)
                {
                    CaseComponent cc = solList.get(desc.getIdAttribute().getValue(desc));
                    if (cc != null) {
                        _case.setSolution(cc);
                    }
                }
                if (this.justOfSolutionClassName != null)
                {
                    CaseComponent cc = justSolList.get(desc.getIdAttribute().getValue(desc));
                    if (cc != null) {
                        _case.setJustificationOfSolution(cc);
                    }
                }
                if (this.resultClassName != null)
                {
                    CaseComponent cc = resList.get(desc.getIdAttribute().getValue(desc));
                    if (cc != null) {
                        _case.setResult(cc);
                    }
                }



                res.add(_case);
            }
        }
        catch (Exception e)
        {
            HashMap<Object, CaseComponent> solList;
            HashMap<Object, CaseComponent> justSolList;
            HashMap<Object, CaseComponent> resList;
            Iterator iter;
            LogFactory.getLog(getClass()).error(e);
        }



        return res;
    }

    public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter filter)
    {









        return null;
    }
}
