package in.sikkandar.service;

import java.sql.SQLException;
import java.util.List;

import in.sikkandar.dao.UserDao;
import in.sikkandar.model.User;
import in.sikkandar.validator.UserValidator;

public class UserService {

	public boolean addDetails(User user) {
		boolean registerd = false;

		boolean nameValid = UserValidator.isNameValid(user.getName());
		boolean emailValid = UserValidator.isEmailValid(user.getEmail());
		boolean mobileValid = UserValidator.isMobileNumberValid(user.getMobile());
		boolean addressValid = UserValidator.isAddressValid(user.getAddress());
		boolean passwordValid = UserValidator.isPasswordValid(user.getPassword());

		if (nameValid && mobileValid && emailValid && addressValid && passwordValid) {

			if (user.getPassword().equals(user.getConfrimPassword())) {

				UserDao.register1(user);
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
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean checkUser(String userName, String userPassword) {
		boolean isValidUser = false;
		List<User> users = UserDao.getUser();
		for (User userDetails : users) {
			if (userDetails.getName().equals(userName) && userDetails.getPassword().equals(userPassword)) {
				isValidUser = true;
				break;

			}
		}
		return isValidUser;
	}

}
