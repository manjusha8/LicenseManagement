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



@WebServlet("/LicenseId")
public class LicenseId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LicenseId() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("license id server");
		
		Cookie ck[] = request.getCookies();
		String firstName = ck[2].getValue();
		String dob = request.getParameter("dob");
		String licenseId = null;
		
		if(firstName.length() < 4) {
			licenseId = firstName.substring(0,firstName.length())+dob+"2020";
		}
		else {
			licenseId = firstName.substring(0,4)+dob+"2020";
		}
		System.out.println("license Id :"+licenseId);
		
		
		LicenseDetails licenseObj = new LicenseDetails();
		licenseObj.setAddress(request.getParameter("address"));
		licenseObj.setPlace(request.getParameter("place"));
//		System.out.println("blood group in servlet :"+request.getParameter("bloodGroup"));
		licenseObj.setBloodGroup(request.getParameter("bloodGroup"));
		licenseObj.setContact(request.getParameter("contact"));
		licenseObj.setDob(Date.valueOf(request.getParameter("dob")));
		licenseObj.setExpiryDate(Date.valueOf(request.getParameter("edate")));
		licenseObj.setIssueDate(Date.valueOf(request.getParameter("idate")));
		licenseObj.setLicenseType(request.getParameter("item"));
		licenseObj.setFatherName(request.getParameter("fatherName"));
		licenseObj.setEmail(ck[0].getValue());
		licenseObj.setFname(ck[2].getValue());
		licenseObj.setLicenseId(licenseId);
		
		System.out.println("details are set");
		
		DBConnection.insertDetails(licenseObj);
		
		System.out.println("details are inserted");
		
		RequestDispatcher r = request.getRequestDispatcher("LicenseDetails.jsp");
		r.forward(request, response);

		
		
		
		
	}

}
