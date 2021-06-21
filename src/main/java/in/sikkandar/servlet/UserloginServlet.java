package in.sikkandar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		try {
			user.checkUser(userName, userPassCode);
			
				HttpSession session = request.getSession();
				session.setAttribute("LOGGED_IN_USER", userName);
				/* session.setAttribute("ROLE", "ADMIN"); */
				response.sendRedirect("Order.jsp");

			
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = "Name or Password is Wrong";
			response.sendRedirect("UserLogin.jsp?errorMessage=" + errorMessage);
		}

	}

}
