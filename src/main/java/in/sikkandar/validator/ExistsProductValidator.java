package in.sikkandar.validator;

import java.util.List;

import in.sikkandar.dao.ProductDao;
import in.sikkandar.exception.ValidationException;
import in.sikkandar.model.Product;



public class ExistsProductValidator {

		public static void existsProduct(int productId1, String productName) throws ValidationException {
			List<Product> product = ProductDao.getProduct();
			
			try {
				for (Product products : product) {
					
					if (products.getId().equals(productId1)) {
						throw new ValidationException("Product id already Exists");
					}
					if (products.getName().equals(productName)) {
						throw new ValidationException("Product name already Exists");
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidationException(e.getMessage());
			}
		
	}

}
