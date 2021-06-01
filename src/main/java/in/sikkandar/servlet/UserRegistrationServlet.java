package in.sikkandar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.sikkandar.service.UserService;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegistrationServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String username = request.getParameter("userName");
			String email = request.getParameter("email");
			String mobileNumber = request.getParameter("mobile");
			String address = request.getParameter("address");
			String password = request.getParameter("pass");
			String confrimPassword = request.getParameter("reenterPass");

			UserService service = new UserService();

			boolean isAdded = service.addDetails(username, email, mobileNumber, address, password, confrimPassword);
			if (isAdded) {
				response.sendRedirect("UserLogin.jsp");

			}
		} catch (Exception e) {
			String errorMessage = "Invalid user details ";
			response.sendRedirect("userRegistration.jsp?errorMessage=" + errorMessage);
		}

	}

}
