package in.sikkandar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.sikkandar.service.ProductService;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String productId = request.getParameter("id");
			int productId1 = Integer.parseInt(productId);
			String productName = request.getParameter("name");
			String productPrice = request.getParameter("price");
			Float productprice1 = Float.parseFloat(productPrice);
			ProductService.addProduct(productId1, productName, productprice1);
			String infoMessage = "Successfully added";
			response.sendRedirect("ListProducts.jsp?infoMessage=" + infoMessage);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			response.sendRedirect("addproduct.jsp?errorMessage=" + errorMessage);
		}
	}
}