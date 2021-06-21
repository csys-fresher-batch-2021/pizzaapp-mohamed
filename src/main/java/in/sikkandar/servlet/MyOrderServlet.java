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

import in.sikkandar.dao.OrderDao;
import in.sikkandar.dao.UserDao;
import in.sikkandar.model.Order;
import in.sikkandar.model.User;

/**
 * Servlet implementation class MyOrderServlet
 */
@WebServlet("/MyOrderServlet")
public class MyOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyOrderServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int userid = 0;
		try {
			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("LOGGED_IN_USER");
			for (User user : UserDao.getUser()) {
				if (user.getName().equals(userName)) {
					userid = user.getUserid();
				}
			}
			List<Order> userOrder = OrderDao.getUserOrders(userid);
			request.setAttribute("ORDER_DETAILS", userOrder);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("MyOrder.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = e.getMessage();
			response.sendRedirect("MyOrder.jsp?errorMessage=" + errorMessage);
		}
	}

		//Integer userid = 1;
//		HttpSession session = request.getSession();
//		String userName = (String) session.getAttribute("LOGGED_IN_USER");
//		for (User user : UserDao.getUser()) {
//			if (user.getName().equals(userName)) {
//				userid = user.getUserid();
//
//			}
//
//		}
	//	List<Order> userOrders = OrderDao.getUserOrders(userid);
	//	System.out.println(userOrders);
	}



