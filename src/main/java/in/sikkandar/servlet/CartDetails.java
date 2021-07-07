package in.sikkandar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import in.sikkandar.dao.UserDao;
import in.sikkandar.exception.ServiceException;
import in.sikkandar.model.User;
import in.sikkandar.service.CartDetailsService;

/**
 * Servlet implementation class CartDetails
 */
@WebServlet("/CartDetails")
public class CartDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartDetails() {
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
			int id = Integer.parseInt(request.getParameter("productId"));
			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("LOGGED_IN_USER");
			for (User user : UserDao.getUser()) {
				if (userName.equals(user.getName())) {
					userid = user.getUserid();
				}
			}
			CartDetailsService.addCart(userid, id);
			String infoMessage = "Successfully Added To Cart";
			response.sendRedirect("ListProducts.jsp?infoMessage=" + infoMessage);
		} catch (ServiceException e) {
			e.printStackTrace();
			String errorMessage = e.getMessage();
			response.sendRedirect("ListProducts.jsp?errorMessage=" + errorMessage);
		}
	}
}
