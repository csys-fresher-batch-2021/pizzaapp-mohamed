package in.sikkandar.validator;

public class UserValidator {
	private UserValidator() {
		
	}
	/**
	 * Check whether name is valid Name must contain character. Numbers special
	 * characters are not accepted
	 * 
	 * @param name
	 * @return
	 */
	public static boolean isNameValid(String name) {
		boolean valid = false;
		String regex = "[a-zA-Z]+\\.?";
		if (name.matches(regex)) {
			valid = true;
		} else {
			valid = false;

		}
		return valid;
	}

	/**
	 * Validating email id. The email id must start with character. The email id can
	 * have number in between. The email id must contain @ in between. After @
	 * symbol email id must contain some character. After that email id must have .
	 * symbol. After . symbol it must have character with the length of 2-7.
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmailValid(String email) {
		boolean valid = false;

		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

		if (email.matches(regex)) {
			valid = true;
		} else {
			valid = false;

		}
		return valid;
	}

	/**
	 * Validating mobile number. The mobile number length should be 10. The mobile
	 * number not a zero.
	 * 
	 * @param mobileNumber
	 * @return
	 */
	public static boolean isMobileNumberValid(long mobileNo) {
		String number = String.valueOf(mobileNo);
		boolean valid = false;
		if (number.length() == 10) {
			valid = true;
		} else {
			valid = false;

		}
		return valid;
	}

	/**
	 * Check whether address is valid Address may contain number and characters.
	 * 
	 * @param name
	 * @return
	 */
	public static boolean isAddressValid(String address) {
		boolean valid = false;
		String regex = "[a-zA-Z0-9]+\\.?";
		if (address.matches(regex)) {
			valid = true;
		} else {
			valid = false;

		}
		return valid;
	}

	/**
	 * Validate password. Password must contain Upper case,special character and
	 * number.
	 * 
	 * @param pass
	 * @return
	 */
	public static boolean isPasswordValid(String pass) {
		boolean valid = false;

		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";

		if (pass != null && pass.matches(regex)) {
			valid = true;
		} else {
			valid = false;

		}

		return valid;
	}

}
