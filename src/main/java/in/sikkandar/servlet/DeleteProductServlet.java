package in.sikkandar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.sikkandar.service.ProductService;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteProductServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String productId = request.getParameter("productId");
		int productId1=Integer.parseInt(productId);
		String productName = request.getParameter("productName");

		boolean isDeleted = ProductService.deleteProduct(productId1, productName);

		if (isDeleted) {
			String infoMessage = "Successfully deleted";
			response.sendRedirect("ListProducts.jsp?infoMessage=" + infoMessage);
		} else {
			String errorMessage = "Unable to delete Product Name";
			response.sendRedirect("DeleteProduct.jsp?errorMessage=" + errorMessage);
		}

	}
}
