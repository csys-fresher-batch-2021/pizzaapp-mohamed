package in.sikkandar.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import in.sikkandar.exception.DBException;
import in.sikkandar.model.User;
import in.sikkandar.util.ConnectionUtil;

public class UserDao {
	private UserDao() {
		// Default Constructor
	}

	/**
	 * get user list in dp
	 * 
	 * @return
	 * @throws DBException
	 */
	public static List<User> getUser() throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		List<User> userReg = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from userregister3";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				User user = new User();
				Integer userId = result.getInt("userid");
				String name = result.getString("name");
				String email = result.getString("email");
				Long mobilenumber = result.getLong("mobilenumber");
				String address = result.getString("address");
				String password = result.getString("password");
				String confirmpassword = result.getString("confirmpassword");
				user.setUserid(userId);
				user.setName(name);
				user.setEmail(email);
				user.setMobile(mobilenumber);
				user.setAddress(address);
				user.setPassword(password);
				user.setConfrimPassword(confirmpassword);
				userReg.add(user);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to fetch User");
		} finally {
			ConnectionUtil.close(connection, pst);
		}
		return userReg;
	}

	/**
	 * add a user in db
	 * 
	 * @param user
	 * @throws DBException
	 */

	public static void register1(User user) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into userregister3(name,email,mobilenumber,address,password,confirmpassword) values(?,?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setLong(3, user.getMobile());
			pst.setString(4, user.getAddress());
			pst.setString(5, user.getPassword());
			pst.setString(6, user.getConfrimPassword());
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Add User");
		} finally {
			ConnectionUtil.close(connection, pst);
		}
	}

	/**
	 * get name in db
	 * 
	 * @param name
	 * @return
	 */
	public static int getUserId(String name) {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select userId from userregister3 where name=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, name);
			result = pst.executeQuery();
			int userId = 0;
			if (result.next()) {
				userId = result.getInt("userId");
			}
			return userId;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to show bill");
		} finally {
			ConnectionUtil.close(connection, pst);
		}
	}
}
