package in.sikkandar.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import in.sikkandar.exception.ValidationException;

public class AddProductsValidator {
	private AddProductsValidator() {
		// default constructor
	}

	public static void isValidProductName(String productName) throws ValidationException {
		String condition = "[a-zA-Z\\s*]+";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(productName);
		if (!matcher.matches()) {
			throw new RuntimeException("InValid ProductName");
		}
	}

	public static void isValidProductPrice(float productPrice) throws ValidationException {
		if (productPrice < 100) {
			throw new ValidationException("Price should be more than 100");
		}
	}

	public static void isValidProductId(int productId) throws ValidationException {
		if (productId < 100) {
			throw new ValidationException("ProductId must be more than 100 ");
		}
	}

}
