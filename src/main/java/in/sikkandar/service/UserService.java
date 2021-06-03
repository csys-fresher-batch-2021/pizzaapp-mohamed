package in.sikkandar.service;

import java.util.List;

import in.sikkandar.dao.UserDao;
import in.sikkandar.model.User;
import in.sikkandar.validator.UserValidator;

public class UserService {
	UserDao userObj = new UserDao();

	public boolean addDetails(String name, String email, long mobileNo, String address, String password,
			String confrimPassword) {
		boolean registerd = false;

		User regObj = new User(name, email, mobileNo, address, password, confrimPassword);
		boolean nameValid = UserValidator.isNameValid(name);
		boolean emailValid = UserValidator.isEmailValid(email);
		boolean mobileValid = UserValidator.isMobileNumberValid(mobileNo);
		boolean addressValid = UserValidator.isAddressValid(address);
		boolean passwordValid = UserValidator.isPasswordValid(password);

		if (nameValid && mobileValid && emailValid && addressValid && passwordValid) {

			if (password.equals(confrimPassword)) {
				userObj.addUser(regObj);
				UserDao.register1(name, email, mobileNo, address, password, confrimPassword);
				registerd = true;

			}

		} else {

			return registerd;
		}
		return registerd;
	}

	/**
	 * To check is the user registered or not.
	 * 
	 * @param userName
	 * @param userPassCode
	 * @return
	 */
	public boolean checkUser(String userName, String userPassword) {
		boolean isValidUser = false;
		List<User> users = UserDao.getUser();
		for (User userDetails : users) {
			if (userDetails.getName().equals(userName) && userDetails.getPassword().equals(userPassword)) {
				isValidUser = true;

			}
		}
		return isValidUser;
	}

}
