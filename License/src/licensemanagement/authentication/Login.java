package licensemanagement.authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletsDemo.db.DBConnection;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		System.out.println("email : "+email);
		System.out.println("password : "+password);
		
		final RegisterDetails registerObj = new RegisterDetails();
		registerObj.setEmail(request.getParameter("email"));
		registerObj.setPassword(request.getParameter("password"));
		
		String msg = null;
//		String addButton = null;
//		String modifyButton = null; 
		
		Cookie ck[] = request.getCookies();
		System.out.println("cookie objects :"+ck);
		if(ck == null) {
			System.out.println("login cookies null");
			final String username = DBConnection.executeRetriveQuery(email, password);
			if(username != null)
			{
				System.out.println("setting cookies 1");
				Cookie ck1 = new Cookie("email",email);
				response.addCookie(ck1);
				System.out.println("cookies mail : "+ck1);
				Cookie ck2 = new Cookie("password",password);
				response.addCookie(ck2);
				System.out.println("cookies password : "+ck2);

				Cookie ck3 = new Cookie("username",username);
				response.addCookie(ck3);
				System.out.println("cookies name : "+ck3);

				System.out.println("setting cookies 2");
				
				request.setAttribute("username", username);
				System.out.println("redirecting to license details");
				
				
				
				
//				if(DBConnection.addDetails(email)) {
//					System.out.println("button event : true");
//					addButton = "disabled";
//					System.out.println("add button disabled : "+DBConnection.addDetails(email));
//					request.setAttribute("addButton", addButton);
////					RequestDispatcher r = request.getRequestDispatcher("LicenseDetails.jsp");
//					System.out.println("redirected to licenseDetails");
////					r.forward(request, response);
//					
//				}
//				else
//				{
//					modifyButton = "disabled";
//					System.out.println("button event : false");
//
//					System.out.println("modify button disabled : true"+modifyButton);
//					request.setAttribute("modifyButton", modifyButton);
////					RequestDispatcher r = request.getRequestDispatcher("LicenseDetails.jsp");
////					r.forward(request, response);
//				}
//				
				
				
				
				
				RequestDispatcher r = request.getRequestDispatcher("ButtonEvent");
				r.forward(request, response);
			}
			else {
				msg = "incorrect user credentials !!";
				RequestDispatcher r = request.getRequestDispatcher("LoginPage.jsp");
				request.setAttribute("msg", msg);
				r.forward(request, response);
			}
		}
		
		if(ck != null) {
			System.out.println("cookies in login are not null");
		}
		
		
		
	}

}
