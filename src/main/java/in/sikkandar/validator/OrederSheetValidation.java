package in.sikkandar.validator;

public class OrederSheetValidation {
	private OrederSheetValidation() {
		
	}
	public static boolean isValidProductQuantity(int quantity) {
		boolean isValid = false;
		if (quantity > 0) {
			isValid = true;
		}
		return isValid;
	}

}
