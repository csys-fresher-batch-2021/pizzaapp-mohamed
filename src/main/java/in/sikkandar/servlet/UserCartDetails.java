package in.sikkandar.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.sikkandar.dao.CartDetailsDao;
import in.sikkandar.dao.UserDao;
import in.sikkandar.exception.DBException;
import in.sikkandar.model.CartDetails;
import in.sikkandar.model.User;

/**
 * Servlet implementation class UserCartDetails
 */
@WebServlet("/UserCartDetails")
public class UserCartDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserCartDetails() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userid = 0;
		try {
			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("LOGGED_IN_USER");
			for (User user : UserDao.getUser()) {
				if (userName.equals(user.getName())) {
					userid = user.getUserid();
				}
			}
			List<CartDetails> userCartList = CartDetailsDao.getUserCartList(userid);
			request.setAttribute("CART_DETAILS", userCartList);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("MyCart.jsp");
			requestDispatcher.forward(request, response);
		} catch (DBException | ServletException | IOException e) {
			e.printStackTrace();
			String errorMessage = e.getMessage();
			response.sendRedirect("MyCart.jsp?errorMessage=" + errorMessage);
		}
	}
}
