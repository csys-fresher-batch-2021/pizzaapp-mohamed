package in.sikkandar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import in.sikkandar.dao.OrderDao;
import in.sikkandar.exception.ServiceException;
import in.sikkandar.model.Order;
import in.sikkandar.util.GsonUtil;

/**
 * Servlet implementation class AllOrderServlet
 */
@WebServlet("/AllOrderServlet")
public class AllOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllOrderServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			List<Order> orders = OrderDao.getAdminBillList();
			Gson gson = GsonUtil.create();
			String json = gson.toJson(orders);
			PrintWriter writer = response.getWriter();
			writer.print(json);
			writer.flush();
		} catch (ServiceException e) {
			JsonObject object = new JsonObject();
			object.addProperty("errorMessage", e.getMessage());
			out.println(object);
		}
		out.flush();
	}
}
