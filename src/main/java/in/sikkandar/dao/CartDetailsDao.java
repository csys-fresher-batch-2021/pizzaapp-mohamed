package in.sikkandar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.sikkandar.exception.DBException;
import in.sikkandar.model.CartDetails;
import in.sikkandar.model.Product;
import in.sikkandar.model.User;
import in.sikkandar.util.ConnectionUtil;

public class CartDetailsDao {
	private CartDetailsDao() {

	}

	public static void addCart(int userid, int id) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = " insert into cartdetails(user_id,product_id) values(?,?);";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, userid);
			pst.setInt(2, id);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable To AddDetails");
		} finally {
			ConnectionUtil.close(connection, pst);
		}
	}

	public static List<CartDetails> getUserCartList(int userId) {
		List<CartDetails> cartList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select cd.id,u.name,ap.productname,ap.productprice from userregister u,addproduct ap,cartdetails cd \r\n"
					+ "where u.userid=cd.user_id and ap.productid=cd.product_id and u.userid=?;";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, userId);
			result = pst.executeQuery();
			while (result.next()) {
				CartDetails cart = new CartDetails();
				User user = new User();
				Product product = new Product();

				Integer cartId = result.getInt("id");
				String userName = result.getString("name");
				String productName = result.getString("productname");
				Float productPrice = result.getFloat("productprice");
			
				cart.setId(cartId);
				user.setName(userName);
				cart.setUser(user);
				product.setName(productName);
				product.setPrice(productPrice);
				cart.setProduct(product);
				cartList.add(cart);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to fetch CartDetails");
		} finally {
			ConnectionUtil.close(connection, pst);
		}
		return cartList;
	}

	public static List<CartDetails> getCartList() {
		List<CartDetails> cartList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select cd.id,u.name,ap.productname,ap.productprice from userregister u,addproduct ap,cartdetails cd \r\n"
					+ "where u.userid=cd.user_id and ap.productid=cd.product_id;";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				CartDetails cart = new CartDetails();
				User user = new User();
				Product product = new Product();


				Integer cartId = result.getInt("id");
				String userName = result.getString("name");
				String productName = result.getString("productname");
				Float productPrice = result.getFloat("productprice");
			
				cart.setId(cartId);
				user.setName(userName);
				cart.setUser(user);
				product.setName(productName);
				product.setPrice(productPrice);
				cart.setProduct(product);
				cartList.add(cart);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to fetch CartDetails");
		} finally {
			ConnectionUtil.close(connection, pst);
		}
		return cartList;
	}

	public static void deleteCart(int userid, int id) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "DELETE FROM cartdetails WHERE user_id= ? and product_id=? ";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, userid);
			pst.setInt(2, id);   
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Delete CartDetails");
		} finally {
			ConnectionUtil.close(connection, pst);
		}
	}

}
