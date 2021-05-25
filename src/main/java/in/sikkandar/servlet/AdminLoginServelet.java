package in.sikkandar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @return 
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServelet() {
        super();
        
        
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("userName");
		String password = request.getParameter("passWord");
		//Step 2: call Service
		boolean isValid = "admin".equals(username) && "admin".equals(password);
		if(isValid) {
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER", username);
			session.setAttribute("ROLE", "ADMIN");
			response.sendRedirect("ModifyProducts.jsp");
		}
		else {
			String errorMessage = "Name or Password is Wrong";
			response.sendRedirect("login.jsp?errorMessage="+errorMessage);
			
		}
		
	}

}
