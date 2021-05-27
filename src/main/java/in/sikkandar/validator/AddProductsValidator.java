package in.sikkandar.validator;



public class AddProductsValidator {
	private AddProductsValidator() {
		// default constructor
	}

	public static boolean isValidProductName(String productName) {
		boolean isValid = false;
		if (productName.trim().isEmpty()) {
			isValid = true;
		}
		return isValid;
	}

	public static boolean isValidProductPrice(String productPrice) {
		int productPrice1 = Integer.parseInt(productPrice);
		boolean isValid = false;
		if (productPrice1 > 100) {
			isValid = true;
		}
		return isValid;
	}

	public static boolean isValidProductId(String productId) {
		int productId1 = Integer.parseInt(productId);
		boolean isValid = false;
		if (productId1 > 100) {
			isValid = true;
		}
		return isValid;
	}

}
