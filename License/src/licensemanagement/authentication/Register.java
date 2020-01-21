package licensemanagement.authentication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletsDemo.db.DBConnection;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
//		String msg =null;
		String email=request.getParameter("email");
		if (!DBConnection.executeRetriveQuery(email)) {
			
			RegisterDetails registerObj = new RegisterDetails();
			registerObj.setFname(request.getParameter("fname"));
			registerObj.setLname(request.getParameter("lname"));
			registerObj.setEmail(request.getParameter("email"));
			registerObj.setPassword(request.getParameter("password"));

			DBConnection.executeInsertQuery(registerObj);
			response.sendRedirect("LoginPage.jsp");
		
		} 
		}

	}
