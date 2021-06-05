package in.sikkandar.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionUtil {

	private ConnectionUtil() {

	}
	
	private static final String DRIVER_CLASS_NAME = System.getenv("spring.datasource.driver-class-name");
	private static final String DATABASE_NAME = System.getenv("spring.datasource.url");
	private static final String USERNAME = System.getenv("spring.datasource.username");
	private static final String PASSWORD =System.getenv( "spring.datasource.password");
	//private static final String HOST="localhost";
	//private static final int PORT =5432;
	private static final String DB_URL= DATABASE_NAME;
	

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
	
		

		Class.forName(DRIVER_CLASS_NAME);

		connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		
		return connection;
	}

	public static void close(Connection con, PreparedStatement pst) {
		try {
			if (con != null) {
				con.close();
				

			}
			if (pst != null) {
				pst.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
}
