package in.sikkandar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.sikkandar.model.User;
import in.sikkandar.service.UserService;
import in.sikkandar.validator.ExistsUserValidator;


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
			long mobileNo = Long.parseLong(request.getParameter("mobile"));
			String address = request.getParameter("address");
			String password = request.getParameter("pass");
			String confrimPassword = request.getParameter("reenterPass");
			
			User user = new User();
			
			user.setName(username);
			user.setEmail(email);
			user.setMobile(mobileNo);
			user.setAddress(address);
			user.setPassword(password);
			user.setConfrimPassword(confrimPassword);
			
			UserService service = new UserService();
			ExistsUserValidator.existsUser(email, mobileNo);

			boolean isAdded = service.addDetails(user);
			
			if (isAdded) {

				String infoMessage = "Registered successfully ";
				response.sendRedirect("UserRegistration.jsp?infoMessage=" + infoMessage);

			}
		} catch (Exception e) {
			String errorMessage =e.getMessage();
			response.sendRedirect("UserRegistration.jsp?errorMessage=" + errorMessage);
		}

	}

}
