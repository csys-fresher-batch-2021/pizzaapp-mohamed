package in.sikkandar.servlet;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.sikkandar.model.Order;
import in.sikkandar.service.OrderSheetService;

/**
 * Servlet implementation class OrderSheetServlet
 */
@WebServlet("/OrderSheetServlet")
public class OrderSheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderSheetServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pizzaType1 = request.getParameter("pizzaType");
		String quantity1 = request.getParameter("quantity");

		/*
		 * int userId=0; HttpSession session = request.getSession(); String username =
		 * (String)session.getAttribute("LOGGED_IN_USER"); for(User user :
		 * UserDao.getUser()) { if(user.getName().equals(username)) { userId =
		 * user.getUserid(); } }
		 */
		try {
			int Quantity = Integer.parseInt(quantity1);
			Order order = OrderSheetService.orderList(pizzaType1, Quantity);
			String deliveryTime = order.getDeliveryTime().format(DateTimeFormatter.ofPattern("HH:mm"));
			System.out.println(deliveryTime);
//			List<Order> orderList = new ArrayList<>();
//			orderList.add(order);
//			request.setAttribute("ORDER_LIST", orderList);
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Bill.jsp");
//			requestDispatcher.forward(request, response);
			response.sendRedirect("Bill.jsp?productName=" + order.getPizzaName() + "&quantity=" + order.getQuantity()
					+ "&price=" + order.getPrice() + "&gstAmount=" + order.getGstAmount() + "&totalPrice="
					+ order.getTotalAmount() + "&deliveryTime=" + deliveryTime);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			String errorMessage = "This Product not available";
			response.sendRedirect("Order.jsp?errorMessage=" + errorMessage);
		}

	}

}
