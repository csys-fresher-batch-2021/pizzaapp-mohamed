package in.sikkandar.validator;

import java.util.List;

import in.sikkandar.dao.UserDao;
import in.sikkandar.model.User;

public class ExistsUserValidator {
	public static void existsUser(String email, long mobilenumber) {
		List<User> users = UserDao.getUser();
		try {
			for (User userDetails : users) {
				if (userDetails.getEmail().equals(email)) {
					throw new RuntimeException("Email Id already Exists");
				}
				if (userDetails.getMobile() == mobilenumber) {
					throw new RuntimeException("Mobile Number already Exists");
				}
				break;

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}

	}

}
