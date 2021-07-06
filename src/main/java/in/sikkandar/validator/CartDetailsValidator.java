package in.sikkandar.validator;

import in.sikkandar.dao.CartDetailsDao;
import in.sikkandar.dao.ProductDao;
import in.sikkandar.dao.UserDao;
import in.sikkandar.exception.ValidationException;
import in.sikkandar.model.CartDetails;
import in.sikkandar.model.Product;
import in.sikkandar.model.User;

public class CartDetailsValidator {
	public static void existsCart(int userid, int id) {
		String userName = "";
		String productName = "";

		for (User user : UserDao.getUser()) {
			if (userid == user.getUserid()) {
				userName = user.getName();
			}
		}
		for (Product product : ProductDao.getProduct()) {
			if (id == product.getId()) {
				productName = product.getName();
			}
		}
		for (CartDetails carts : CartDetailsDao.getCartList()) {
			if (userName.equals(carts.getUser().getName())
					&& productName.equals(carts.getProduct().getName())) {
				throw new ValidationException("The product is already addtocart");

			}

		}

	}



}
