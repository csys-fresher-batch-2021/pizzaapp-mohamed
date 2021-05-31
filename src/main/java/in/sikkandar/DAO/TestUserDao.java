package in.sikkandar.DAO;



public class TestUserDao {
	public static void main(String args[]) {
		
		String name  = "tamil";
		String email = "tamil@gmail.com";
		String mobileNum = "9861235667";
		String address = "trichy";
		String password= "Sikki@123";
		String confrimPassword="Sikki@123";
		UserDao.register1(name, email, mobileNum, address, password, confrimPassword);
		//UserDao.deleteBook(bookName);
	}
}
