package in.sikkandar.service;

import java.util.ArrayList;
import java.util.List;

import in.sikkandar.model.Product;
import in.sikkandar.validator.AddProductsValidator;

public class ProductService {

	private ProductService() {

	}

	private static final List<Product> products = new ArrayList<>();

	static {

		products.add(new Product("101", "VegPizza", "150"));
		products.add(new Product("102", "MushroomPizza", "200"));
		products.add(new Product("103", "PannerPizza", "250"));

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

	public static boolean addProduct(String productName, String productPrice, String productId) {

		boolean isAdded = false;

		if (!AddProductsValidator.isValidProductName(productName)
				&& AddProductsValidator.isValidProductPrice(productPrice)
				&& AddProductsValidator.isValidProductId(productId)) {

			Product product = new Product(productId, productName, productPrice);
			products.add(product);

			isAdded = true;
		}
		return isAdded;

	}

	public static boolean deleteProduct(String productName, String productId) {

		boolean isDeleted = false;
		Product searchProduct = null;
		for (Product product : products) {
			if (product.getName().equals(productName) && product.getId().equals(productId)) {
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
