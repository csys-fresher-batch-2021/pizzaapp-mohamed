package in.sikkandar.validator;

public class AddProductsValidator {
	private AddProductsValidator() {
		// default constructor
	}

	public static boolean isValidProductName(String productName) {
		boolean isValid = false;
		for (int i = 0; i < productName.length(); i++) {
			char ch = productName.charAt(i);
			if (!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')) {

				isValid = true;
			}
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
