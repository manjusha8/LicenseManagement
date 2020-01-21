package licensemanagement.authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletsDemo.db.DBConnection;


@WebServlet("/RegisterEmail")
public class RegisterEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterEmail() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("register email servlet");
		
		PrintWriter out = response.getWriter();
		
		String msg =null;
		String regex = "^([\\w]*[\\w\\.]*(?!\\.)@gmail.com)";
		String email=request.getParameter("email");
		
		Pattern pattern = Pattern.compile(regex);
		
		if (DBConnection.executeRetriveQuery(email)) {
			msg = "exists";

			System.out.println("email is : "+msg);
			out.println("username not available !!");
		}

		else
		{
			System.out.println("regex");
			Matcher matcher = pattern.matcher(email);
			System.out.println("matcher :"+matcher.matches());
			if(matcher.matches())
			{
				out.println("username available");

			}
			else {
				out.println("username not available !!");
			}
			System.out.println("email is : "+email);
		}
		
		
		
	}

}
