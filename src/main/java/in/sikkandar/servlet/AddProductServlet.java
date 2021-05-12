package in.sikkandar.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		

		// Step 1: Get Form Values
		String productName = request.getParameter("productName");
		out.println(productName);

		// Step 2: Call Service => add Product
		boolean isAdded = ProductService.addProduct(productName);

		// Step 3: Decide to which page we should redirect ?
		if (isAdded) {
			response.sendRedirect("ListProducts.jsp");
		} else {
			String errorMessage = "Unable to add Product Name";
			response.sendRedirect("addproduct.jsp?errorMessage=" + errorMessage);
		}
	}
}
