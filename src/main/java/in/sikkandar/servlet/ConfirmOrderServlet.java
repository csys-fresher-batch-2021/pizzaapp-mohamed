package in.sikkandar.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import in.sikkandar.dao.OrderDao;
import in.sikkandar.dao.ProductDao;
import in.sikkandar.dao.UserDao;
import in.sikkandar.model.Order;
import in.sikkandar.model.Product;
import in.sikkandar.model.User;

/**
 * Servlet implementation class ConfirmOrderServlet
 */
@WebServlet("/ConfirmOrderServlet")
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfirmOrderServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String productName = request.getParameter("productName");
			Integer quantity = Integer.parseInt(request.getParameter("quantity"));
			float price = Float.parseFloat(request.getParameter("price"));
			double gstAmount = Float.parseFloat(request.getParameter("gstAmount"));
			float totalAmount = Float.parseFloat(request.getParameter("totalAmount"));
			int userId = 0;
			int productId = 0;
			LocalTime orderTime = LocalTime.now();
			LocalTime deliveryTime = orderTime.plusMinutes(30);
			LocalDate date = LocalDate.now();
			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("LOGGED_IN_USER");
			for (User users : UserDao.getUser()) {
				if (userName.trim().equals(users.getName())) {
					userId = users.getUserid();
				}
			}
			for (Product product : ProductDao.getProduct()) {
				if (productName.trim().equals(product.getName())) {
					productId = product.getId();
					break;
				}
			}
			Order orders = new Order();
			User users = new User();
			users.setUserid(userId);
			orders.setUser(users);
			Product products = new Product();
			products.setId(productId);
			orders.setProduct(products);
			orders.setDate(date);
			orders.setTime(orderTime);
			orders.setDeliveryTime(deliveryTime);
			orders.setPizzaName(productName);
			orders.setQuantity(quantity);
			orders.setPrice(price);
			orders.setGstAmount(gstAmount);
			orders.setTotalAmount(totalAmount);
			OrderDao.addOrder(orders);
			String infoMessage = "Your Order Successfully Placed";
			response.sendRedirect("ConfirmOrder.jsp?infoMessage=" + infoMessage);
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = e.getMessage();
			response.sendRedirect("ConfirmOrder.jsp?errorMessage" + errorMessage);
		}
	}
}
