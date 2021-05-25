package in.sikkandar.service;

import java.util.ArrayList;
import java.util.List;

import in.sikkandar.model.Product;

public class ProductService {

	public static final String regularexpression = "^[a-zA-Z][a-zA-Z0-9_]{6,19}$";

	private ProductService() {
		// private constructor to avoid object creation
	}

	private static final List<Product> products = new ArrayList<>();

	static {

		// List of products in the list
		products.add(new Product(1, "VegPizza", "150"));
		products.add(new Product(2, "MushroomPizza", "200"));
		products.add(new Product(3, "PannerPizza", "250"));

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

	public static boolean addProduct(String productName, String price) {

		if (productName.matches(ProductService.regularexpression)) {

			int id = products.size() + 1; // 11
			products.add(new Product(id, productName, price));

		} else {
			return false;
		}
		return true;

	}
	
	
	
	@SuppressWarnings("unlikely-arg-type")
	public static boolean deleteProduct(String productName,String productId) {
		
		boolean isDeleted = false;
		Product searchProduct = null;
		for(Product product: products) {
			if(product.getName().equalsIgnoreCase(productName) || product.getId().equals(productId)) {
				searchProduct = product;
				break;
			}
		}
		if(searchProduct != null) {
			products.remove(searchProduct);
			isDeleted = true;
		}
		return isDeleted;
	}
}
