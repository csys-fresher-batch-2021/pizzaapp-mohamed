package in.sikkandar.service;

import java.util.ArrayList;
import java.util.List;

import in.sikkandar.model.Product;
import in.sikkandar.validator.AddProductsValidator;

public class ProductService {

	ProductService() {

	}

	private static final List<Product> products = new ArrayList<>();

	static {
		
		Product product1=new Product(101, "VegPizza", 150f);
		products.add(product1);
		Product product2=new Product(102, "MushroomPizza", 200f);
		products.add(product2);
		Product product3=new Product(103, "PannerPizza", 250f);
		products.add(product3);
		//products.add(new Product(102, "MushroomPizza", 200f));
	//products.add(new Product(103, "PannerPizza", 250f));

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

	public static boolean addProduct(int productId1,String productName,float productprice1) {

		boolean isAdded = false;

		if (!AddProductsValidator.isValidProductName(productName)
				&& AddProductsValidator.isValidProductPrice(productprice1)
				&& AddProductsValidator.isValidProductId(productId1)) {

			Product product = new Product(productId1, productName, productprice1);
			products.add(product);

			isAdded = true;
		}
		return isAdded;

	}

	public static boolean deleteProduct(int productId1,String productName) {

		boolean isDeleted = false;
		Product searchProduct = null;
		for (Product product : products) {
			if (product.getName().equals(productName) && product.getId().equals(productId1)) {
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
