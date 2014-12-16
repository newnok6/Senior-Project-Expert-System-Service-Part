package jcolibri.examples.Pizza;

import jcolibri.cbrcore.Attribute;
import jcolibri.datatypes.Instance;
import jcolibri.examples.TravelRecommender.TravelDescription.AccommodationTypes;
import jcolibri.examples.TravelRecommender.TravelDescription.Seasons;

public class PizzaDescription implements jcolibri.cbrcore.CaseComponent {
	///public enum Size  {large , medium , small};
	
	String  caseId;
	String  typeOfpizza;
	
	double numberOfPersons;
    double activeIngredient;
	//Size size;
	//Integer price;
//	public PizzaDescription(){
		
	//	this.size = size;
		
	//}
	public String toString()
	{
		return "("+caseId+";"+typeOfpizza+";"+numberOfPersons+")";
	}
	//public Size getSize(){
		//return this.size;
	//}
	//public void setSize(Size size){
		//this.size = size;
		
	//}
	////ublic Integer getPrice(){
		///return this.price;
		
	//}
	//public void setPrice(Integer price){
	//	this.price = price;
		
	///}

	public String getTypeOfpizza(){
		
		return this.typeOfpizza;
	}
	public void setTypeOfpizza(String typeOfpizza){
		this.typeOfpizza = typeOfpizza;
	}
	

	public void setNumberOfPersons(Integer numberOfPersons ){
		this.numberOfPersons = numberOfPersons;
	}
	
	public String getCaseId() {
		return caseId;
	}
	/**
	 * @param caseId the caseId to set
	 */
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	/**
	 * @return the accomodation
	 */



	public Attribute getIdAttribute() {
		return new Attribute("caseId", this.getClass());
	}

}
