package licensemanagemnet.displaydetails;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletsDemo.db.DBConnection;


@WebServlet("/FetchServlet")
public class FetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FetchServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("fetch details servlet");
		PrintWriter out = response.getWriter();
		
		Cookie ck[] = request.getCookies();
		
//		String fetchDetails[] = DBConnection.fetchDetails(ck[0].getValue()).split(",");
		out.print(DBConnection.fetchDetails(ck[0].getValue()));
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
