package jcolibri.examples.Pizza;

import jcolibri.cbrcore.Attribute;

public class PizzaSolution implements jcolibri.cbrcore.CaseComponent {

	String id;
	String pizza;
	
	
	public String toString()
	{
		return "("+id+";"+pizza+")";
	}
	public String getId(){
		return this.id;
	}
	public void setId(String id ){
		
		this.id = id;
		
	}
	public String getPizza(){
		return this.pizza;
	}
	public void setPizza(String pizza ){
		
		this.pizza = pizza;
		
	}
	public Attribute getIdAttribute() {
		
		return new Attribute("id", this.getClass());
	}

	/**
	 * @return Returns the hotel.
	 */
	
	

}
