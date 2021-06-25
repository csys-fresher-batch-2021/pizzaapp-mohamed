package in.sikkandar.service;

import in.sikkandar.dao.ProductDao;
import in.sikkandar.exception.ServiceException;
import in.sikkandar.model.Product;
import in.sikkandar.validator.AddProductsValidator;
import in.sikkandar.validator.ExistsProductValidator;

public class ProductService {
	ProductService() {
		// Default Constructor
	}

	/**
	 * 
	 * @param productId1
	 * @param productName
	 * @param productprice1
	 * @throws ServiceException
	 */
	public static void addProduct(int productId1, String productName, Float productprice1) throws ServiceException {

		try {
			AddProductsValidator.isValidProductName(productName);
			AddProductsValidator.isValidProductPrice(productprice1);
			AddProductsValidator.isValidProductId(productId1);
			ExistsProductValidator.existsProduct(productId1, productName);
			Product product = new Product(productId1, productName, productprice1);
			ProductDao.addProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * 
	 * @param productId
	 * @param productName
	 */

	public static void deleteProduct(int productId, String productName) {
		try {
			Product searchProduct = null;
			for (Product product : ProductDao.getProduct()) {
				if (product.getName().equals(productName) && product.getId().equals(productId)) {
					ProductDao.deleteProduct(productId, productName);
					searchProduct = product;
					break;
				}
			}
			if (searchProduct != null) {
				ProductDao.getProduct().remove(searchProduct);
			} else {
				throw new ServiceException("No Mathching Books Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
}