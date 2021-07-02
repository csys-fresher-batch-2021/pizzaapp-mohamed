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
		String pizzaType = request.getParameter("pizzaType");
		int Quantity = Integer.parseInt( request.getParameter("quantity"));
		try {
			
			Order order = OrderSheetService.orderList(pizzaType, Quantity);
			String deliveryTime = order.getDeliveryTime().format(DateTimeFormatter.ofPattern("HH:mm"));
			response.sendRedirect("Bill.jsp?productName=" + order.getPizzaName() + "&quantity=" + order.getQuantity()
					+ "&price=" + order.getPrice() + "&gstAmount=" + order.getGstAmount() + "&totalPrice="
					+ order.getTotalAmount() + "&deliveryTime=" + deliveryTime);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			response.sendRedirect("Order.jsp?errorMessage=" + errorMessage);
		}
	}
}
