package in.sikkandar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.sikkandar.dao.ProductDao;
import in.sikkandar.dao.UserDao;
import in.sikkandar.model.Product;
import in.sikkandar.model.User;
import in.sikkandar.service.CartDetailsService;

/**
 * Servlet implementation class DeleteCartServlet
 */
@WebServlet("/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCartServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productName = request.getParameter("productName");
		int userid = 0;
		int id = 0;
		try {
			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("LOGGED_IN_USER");
			for (User user : UserDao.getUser()) {
				if (userName.equals(user.getName())) {
					userid = user.getUserid();
				}
			}
			for (Product product : ProductDao.getProduct()) {
				if (productName.equals(product.getName())) {
					id = product.getId();
				}
			}
			CartDetailsService.deleteUser(userid, id);
			String infoMessage = "Successfully Removed";
			response.sendRedirect("UserCartDetails?infoMessage=" + infoMessage);
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = e.getMessage();
			response.sendRedirect("MyCart.jsp" + errorMessage);
		}
	}

}
