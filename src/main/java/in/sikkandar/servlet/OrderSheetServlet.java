package in.sikkandar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pizzaType1 = request.getParameter("pizzaType");
		String quantity1 = request.getParameter("quantity");
		int Quantity=Integer.parseInt(quantity1);
		
		double gst=0.07;
		boolean isAdded = OrderSheetService.orderList(pizzaType1,Quantity);
		OrderSheetService.gstCalculation(pizzaType1,gst);

		if (isAdded) {
			response.sendRedirect("Bill.jsp");
			
		} else {
			String errorMessage = "Unable to add Product Name";
			response.sendRedirect("Order.jsp?errorMessage=" + errorMessage);
		}

	}

}
