package in.sikkandar.service;

import java.util.ArrayList;
import java.util.List;

import in.sikkandar.dao.ProductDao;
import in.sikkandar.model.Product;
import in.sikkandar.validator.AddProductsValidator;
import in.sikkandar.validator.ExistsProductValidator;

public class ProductService {

	ProductService() {

	}

	private static final List<Product> products = new ArrayList<>();

	static {

		Product product1 = new Product(101, "VegPizza", 150f);
		products.add(product1);
		Product product2 = new Product(102, "MushroomPizza", 200f);
		products.add(product2);
		Product product3 = new Product(103, "PannerPizza", 250f);
		products.add(product3);

	}

	/**
	 * method to display the products available
	 * 
	 * @return
	 * 
	 */
	public static List<Product> getProducts() {
		return products;
	}

	public static void addProduct(int productId1, String productName, Float productprice1) {

		try {
			AddProductsValidator.isValidProductName(productName);
			AddProductsValidator.isValidProductPrice(productprice1);
			AddProductsValidator.isValidProductId(productId1);

			ExistsProductValidator.existsProduct(productId1, productName);
			Product product = new Product(productId1, productName, productprice1);
			products.add(product);
			ProductDao.addProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}

	}

	public static boolean deleteProduct(int productId, String productName) {

		boolean isDeleted = false;
		Product searchProduct = null;
		for (Product product : products) {
			if (product.getName().equals(productName) && product.getId().equals(productId)) {
				ProductDao.deleteProduct(productId, productName);
				searchProduct = product;
				break;
			}
		}
		if (searchProduct != null) {
			products.remove(searchProduct);
			isDeleted = true;
		}
		return isDeleted;
	}
}