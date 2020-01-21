package licensemanagement.event;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ModifyDetails")
public class ModifyDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyDetails() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String modify = "true";
		request.setAttribute("modify", modify);
		Cookie ck[] = request.getCookies();
		request.setAttribute("username", ck[2].getValue());
		RequestDispatcher r = request.getRequestDispatcher("LicenseDetails.jsp");
		r.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
