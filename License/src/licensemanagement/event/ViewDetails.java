package licensemanagement.event;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ViewDetails")
public class ViewDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewDetails() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("view details dervlet");


		Cookie ck[] = request.getCookies();
		String em = ck[0].getValue();
		System.out.println("email id of cookie : "+em);

		
		
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html"); 
        System.out.println("content type");
        out.println("<html><body>");  
        try 
        {  
        	System.out.println("try block");
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");  
            System.out.println("connection executed");
            System.out.println(em);
            String query = "select * from license_details where email = ?";
            PreparedStatement ps = con.prepareStatement(query);  
            System.out.println(em);
            System.out.println("this is query : "+query);
			ps.setString(1, em
					);
            ResultSet rs = ps.executeQuery();  
            System.out.println("result set");
            out.println("<table border=1>");  
            out.println("<tr><th>licenseId</th><th>firstName</th><th>contact</th><th>email</th><th>bloodGroup</th><th>address</th><th>place</th><th>fatherName</th><tr>");  
            while (rs.next()) 
            {  
                String id = rs.getString("licenseId");  
                String fname = rs.getString("firstName");  
                String contact = rs.getString("contactNo");
                String email = rs.getString("email"); 
                String bloodGroup = rs.getString("bloodGroup");
                String address = rs.getString("address");
                String place = rs.getString("place");
                String fatherName = rs.getString("fatherName");


                out.println("<tr><td>" + id + "</td><td>" + fname + "</td><td>" + contact + "</td><td>"+ email +"</td><td>" + bloodGroup +"</td><td>"+ address +"</td><td>"+ place +"</td><td>"+ fatherName +"</td></tr>");   
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            con.close();  
           }  
            catch (Exception e) 
           {  
            e.printStackTrace();
        }  
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
