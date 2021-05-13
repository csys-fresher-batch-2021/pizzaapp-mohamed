package in.sikkandar.service;



import java.util.ArrayList;
import java.util.List;


import in.sikkandar.model.Product;



public class ProductService {
	
	public static final String regularexpression = "^[a-zA-Z][a-zA-Z0-9_]{6,19}$";
	private ProductService() {
		//private constructor to avoid object creation
	}
	public static final ArrayList<Product>  products = new ArrayList<>();
	
	static {
		
		
		 //List of products in the list
		products.add( new Product(1, "VegPizza"));
		products.add( new Product(2, "MushroomPizza"));
		products.add( new Product(3, "PannerPizza"));
		
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
	public static boolean addProduct(String productName) {
		
		if (productName.matches(ProductService.regularexpression)) {
			System.out.println("Successfully added " + productName);
			int id = products.size() + 1; //11
			products.add(new Product(id, productName));

		} else {
			System.out.println("INVALID" + "\n" + productName);
			System.out.println("PLEASE ENTER THE VALID PRODUCT NAME");

		}
		return true;
		
	}
	
	
	
	
	
	
}

