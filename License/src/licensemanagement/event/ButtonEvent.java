package licensemanagement.event;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletsDemo.db.DBConnection;

@WebServlet("/ButtonEvent")
public class ButtonEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ButtonEvent() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("button event servlet");
		String addButton = null;
		String modifyButton = null; 
		Cookie ck[] = request.getCookies();
		String email = ck[0].getValue();
		System.out.println("email in button event :"+email);
		if(DBConnection.addDetails(email)) {
			System.out.println("button event : true");
			addButton = "disabled";
			System.out.println("add button disabled : "+DBConnection.addDetails(email));
			request.setAttribute("addButton", addButton);
			RequestDispatcher r = request.getRequestDispatcher("LicenseDetails.jsp");
			System.out.println("redirected to licenseDetails");
			r.forward(request, response);
			
		}
		else
		{
			modifyButton = "disabled";
			System.out.println("button event : false");

			System.out.println("modify button disabled : true"+modifyButton);
			request.setAttribute("modifyButton", modifyButton);
			RequestDispatcher r = request.getRequestDispatcher("LicenseDetails.jsp");
			r.forward(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
