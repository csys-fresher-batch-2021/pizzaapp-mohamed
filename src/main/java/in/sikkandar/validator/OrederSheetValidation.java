package in.sikkandar.validator;

import java.util.List;

import in.sikkandar.dao.ProductDao;
import in.sikkandar.exception.ValidationException;
import in.sikkandar.model.Product;

public class OrederSheetValidation {
	private OrederSheetValidation() {

	}
	
	public static void noProduct(String pizzaType) {
		boolean isValid=false;
		List<Product> product = ProductDao.getProduct();
			for (Product products : product) {
				if (products.getName().equalsIgnoreCase(pizzaType)) {
					isValid=true;
					break;
				}
			}
			if(!isValid) {
				throw new ValidationException("This Product Not Available");
			}
		} 
		
	public static boolean isValidProductQuantity(int quantity) {
		boolean isValid = false;
		if (quantity > 0) {
			isValid = true;
		}
		return isValid;
	}
}
