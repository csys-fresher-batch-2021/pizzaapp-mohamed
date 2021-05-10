package in.sikkandar.service;

import java.util.HashMap;

public class AddPizzaTypes {
	
	/**
	 * Array List to store pizzaTypes
	 */
	public static HashMap<Integer, String> pizzaTypes = new HashMap<Integer, String>();
	
	
	/**
	 * Add a pizza name
	 *  
	 * @param pizzaName
	 * @return
	 */
	public static boolean addPizzaTypes(int pizzaId,String pizzaName) {
		pizzaTypes.put(pizzaId,pizzaName);
		return true;
	}


}
