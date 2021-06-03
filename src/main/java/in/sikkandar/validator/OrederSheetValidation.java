package in.sikkandar.validator;

public class OrederSheetValidation {
	public static boolean isValidProductQuantity(int Quantity) {
		boolean isValid = false;
		if (Quantity > 0) {
			isValid = true;
		}
		return isValid;
	}

}
