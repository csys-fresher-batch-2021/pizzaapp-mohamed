package in.sikkandar.service;

import in.sikkandar.dao.CartDetailsDao;
import in.sikkandar.exception.DBException;
import in.sikkandar.exception.ServiceException;
import in.sikkandar.exception.ValidationException;
import in.sikkandar.validator.CartDetailsValidator;

public class CartDetailsService{
	private CartDetailsService() {
		
	}
	public static void addCart(int userid,int id) throws ServiceException {
		try {
			CartDetailsValidator.existsCart(userid,id);
			CartDetailsDao.addCart(userid,id);
		} catch (ValidationException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
	public static void deleteUser(int userid,int id) {
		try {
			CartDetailsDao.deleteCart(userid,id);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
}
