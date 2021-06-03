package in.sikkandar.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import in.sikkandar.model.User;
import in.sikkandar.util.ConnectionUtil;

public class UserDao {
	
	private static final List<User> userReg = new ArrayList<>();

	public void addUser(User regObj) {

		userReg.add(regObj);

	}

	public static List<User> getUser() {

		return userReg;
	}

	public static void register1(String name, String email, long mobileNumber, String address, String password,
			String confrimPassword) {

		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into register5(name,email,mobileNum,address,password,confrimPassword) values(?,?,?,?,?,?)";

			pst = connection.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setLong(3, mobileNumber);
			pst.setString(4, address);
			pst.setString(5, password);
			pst.setString(6, confrimPassword);
			
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, pst);

		}

	}


}
