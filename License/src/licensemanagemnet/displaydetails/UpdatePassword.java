package licensemanagemnet.displaydetails;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import licensemanagement.authentication.RegisterDetails;
import servletsDemo.db.DBConnection;

@WebServlet("/UpdatePassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdatePassword() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String message = null;
		
		final RegisterDetails registerObj = new RegisterDetails();
		registerObj.setEmail(request.getParameter("email"));
		registerObj.setPassword(request.getParameter("password"));
		final String username = DBConnection.executeRetriveQuery(email, pass);
		if(username != null) {
			registerObj.setPassword(request.getParameter("NewPassword"));
			if(DBConnection.updateQuery(registerObj))
			{
				message = "new password is set";
			}
		}
		else {
			message = "incorrect credentials";
		}
		Cookie ck[] = request.getCookies();
		request.setAttribute("username", ck[2].getValue());
		request.setAttribute("message", message);
		RequestDispatcher r1 = request.getRequestDispatcher("LicenseDetails.jsp");
		r1.forward(request, response);
		
		
	}

}
