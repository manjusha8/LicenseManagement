package licensemanagemnet.displaydetails;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletsDemo.db.DBConnection;

/**
 * Servlet implementation class UpdateDetails
 */
@WebServlet("/UpdateDetails")
public class UpdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateDetails() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Cookie ck[] = request.getCookies();
		String email = ck[0].getValue();
		LicenseDetails licenseObj = new LicenseDetails();
		
		System.out.println("update details servlet");
		System.out.println(" mail id :"+email);
		
		licenseObj.setEmail(email);

		String password = null;
		
		
		if(DBConnection.addDetails(email))
		{
			System.out.println("inside block");

			licenseObj.setAddress(request.getParameter("address"));
			licenseObj.setPlace(request.getParameter("place"));
			licenseObj.setBloodGroup(request.getParameter("bloodGroup"));
			licenseObj.setContact(request.getParameter("contact"));
			licenseObj.setDob(Date.valueOf(request.getParameter("dob")));
			DBConnection.updateDetails(licenseObj);
			System.out.println(DBConnection.updateDetails(licenseObj));
			System.out.println("detials updated");

		}
	
		request.setAttribute("password", password);
		System.out.println("password is set to "+password);
		
		RequestDispatcher r = request.getRequestDispatcher("LicenseDetails.jsp");
		r.forward(request, response);

	
	
	}

}
