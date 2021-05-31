package in.sikkandar.service;

import java.util.List;

import in.sikkandar.DAO.UserDao;
import in.sikkandar.model.User;
import in.sikkandar.validator.UserValidator;

public class UserService {
	UserDao userObj = new UserDao();

	public boolean addDetails(String name, String email,String mobileNumber, String address, String password,
			String confrimPassword) {
		boolean registerd = false;
	
		
		User regObj = new User(name, email, mobileNumber, address, password, confrimPassword);
		boolean nameValid = UserValidator.isNameValid(name);
		boolean emailValid = UserValidator.isEmailValid(email);
		boolean mobileValid = UserValidator.isMobileNumberValid(mobileNumber);
		boolean addressValid = UserValidator.isAddressValid(address);
		boolean passwordValid = UserValidator.isPasswordValid(password);
		
		if (nameValid && mobileValid && emailValid && addressValid && passwordValid) {

			if (password.equals(confrimPassword)) {
				userObj.addUser(regObj);
				UserDao.register1(name, email, mobileNumber, address, password, confrimPassword);
				registerd = true;
				
			} else {
				System.out.println("Invalid confrim password");
			}

		} else {
			System.out.println("Invalid details");
			registerd = false;
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
