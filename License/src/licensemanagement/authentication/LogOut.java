package licensemanagement.authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LogOut() {
        super();
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("logout servlet ");
		
		Cookie[] ck = request.getCookies();
		Cookie cookie = null;
		System.out.println(request.getCookies());
		
		for(int i =0 ; i<ck.length;i++)
		{
			cookie= ck[i];
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			
			
		}
				
		System.out.println("cookies removed ");

		response.sendRedirect("IndexWelcome.jsp");
		
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
