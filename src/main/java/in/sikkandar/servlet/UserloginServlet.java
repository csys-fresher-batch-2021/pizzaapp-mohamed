package in.sikkandar.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.sikkandar.service.UserService;

/**
 * Servlet implementation class UserloginServlet
 */
@WebServlet("/UserloginServlet")
public class UserloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserloginServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String userPassCode = request.getParameter("password");
		UserService user = new UserService();
		boolean isValidUser;
		try {
			isValidUser = user.checkUser(userName, userPassCode);
			if (isValidUser) {
				response.sendRedirect("Order.jsp");

			} 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			String errorMessage = "Name or Password is Wrong";
			response.sendRedirect("UserLogin.jsp?errorMessage=" + errorMessage);
		}

	}

}
