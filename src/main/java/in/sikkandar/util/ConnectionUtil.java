package in.sikkandar.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class ConnectionUtil {
	
	private ConnectionUtil() {

	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection=null;
		
		String driverClass = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/Register_db";
		String username = "postgres";
		String password = "pass123";
		// Step 1: Load the jdbc driver in memory
		Class.forName(driverClass);
		// Step 2: Get the connection
		 connection = DriverManager.getConnection(url, username, password);
		 System.out.println("connected");

		return connection;
	}
	
	public static void close(Connection con,PreparedStatement pst) {
		try {
			if (con != null) {
				con.close();
				System.out.println("close");

			}
			if(pst!=null) {
				pst.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
}
