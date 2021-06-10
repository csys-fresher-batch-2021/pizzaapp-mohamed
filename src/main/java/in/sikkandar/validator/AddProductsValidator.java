package in.sikkandar.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddProductsValidator {
	private AddProductsValidator() {
		// default constructor
	}

	public static void isValidProductName(String productName) {
		String condition = "[a-zA-Z\\s*]+";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(productName);
		if (!matcher.matches()) {
			throw new RuntimeException("InValid ProductName");
		}
	}

	public static void isValidProductPrice(float productPrice) {
		if (productPrice < 100) {
			throw new RuntimeException("Price should be more than 100");
		}
	}

	public static void isValidProductId(int productId) {
		if (productId < 100) {
			throw new RuntimeException("ProductId must be more than 100 ");
		}
	}

}
