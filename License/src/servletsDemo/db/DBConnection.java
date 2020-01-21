package servletsDemo.db;

//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import licensemanagement.authentication.RegisterDetails;
import licensemanagemnet.displaydetails.LicenseDetails;


public class DBConnection {
	
	private static Connection connection;
	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	public static Connection getConnection() {
		return connection;
	}

	public static boolean executeInsertQuery(final RegisterDetails registerObj) {

		final String query = "insert into license_registration values(?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, registerObj.getFname());
			ps.setString(2, registerObj.getLname());
			ps.setString(3, registerObj.getEmail());
			ps.setString(4, registerObj.getPassword());

			ps.executeUpdate();
			System.out.println("insert"+ps.executeUpdate());

		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	
	
//	public static boolean viewDetails(final String email) {
//
//		final String query = "select licenseId , firstName,contact ,email , bloodGroup,address,place,fatherName,issueDate,expiryDate,licenseType,dob from license_details where email = ?";
//		
//		try {
//			PreparedStatement ps = connection.prepareStatement(query);
//			ps.setString(1, email);
//			ResultSet resultSet = ps.executeQuery();
//			System.out.println("retrive"+resultSet);
//			if(resultSet.next()) {
//				
//				return true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//	
//	
	
	
	public static String fetchDetails(String email) {
		final String query = "select * from license_details where email = ?";
		try {
			PreparedStatement st = connection.prepareStatement(query);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				System.out.println("license type  : "+rs.getString("licenseType"));

				return rs.getString("licenseId")+","+rs.getString("firstName")+","+rs.getString("contactNo")+","+rs.getString("email")+","+rs.getString("bloodGroup")+","+rs.getString("address")+","+rs.getString("place")+","+rs.getString("fatherName")+","+rs.getString("issueDate")+","+
						rs.getString("expiryDate")+","+rs.getString("licenseType")+","+rs.getString("dob");
			
			
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public static boolean insertDetails(final LicenseDetails licenseObj) {
		final String query = "insert into license_details values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,licenseObj.getLicenseId());
			ps.setString(2, licenseObj.getFname());
			ps.setString(3,licenseObj.getContact());
			ps.setString(4,licenseObj.getEmail());
			ps.setString(5,licenseObj.getBloodGroup());
			ps.setString(6,licenseObj.getAddress());
			ps.setString(7,licenseObj.getPlace());
			ps.setString(8,licenseObj.getFatherName());
			ps.setDate(9, licenseObj.getIssueDate());
			ps.setDate(10, licenseObj.getExpiryDate());
			ps.setString(11, licenseObj.getLicenseType());
			ps.setDate(12, licenseObj.getDob());
			ps.executeUpdate();
			System.out.println("insert"+ps.executeUpdate());

		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	
	
	
	public static boolean updateDetails(final LicenseDetails licenseObj) {
		final String query = "update license_details set contactNo = ? , bloodGroup = ? , address = ? , place = ? , dob = ? where email = ?";
		try {
			System.out.println("query for update :"+ query);
			System.out.println("before updating");
			System.out.println("email is : "+licenseObj.getEmail());
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,licenseObj.getContact());
			ps.setString(2,licenseObj.getBloodGroup());
			ps.setString(3,licenseObj.getAddress());
			ps.setString(4,licenseObj.getPlace());
			ps.setDate(5, licenseObj.getDob());
			ps.setString(6, licenseObj.getEmail());
			System.out.println("hi");
			ps.executeUpdate();
			System.out.println("hello");
			System.out.println(ps);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	
	
	public static boolean executeDetails(final String licenseId) {

		final String query = "select email from license_registration where licenseId = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, licenseId);
			ResultSet resultSet = ps.executeQuery();
			System.out.println("retrive"+resultSet);
			if(resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	public static boolean addDetails(final String email) {

		final String query = "select email from license_details where email = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();
			System.out.println("retrive details : "+resultSet);
			if(resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	public static boolean updateQuery(final RegisterDetails registerObj) {
		final String query = "update license_registration set password = ? where email = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
//			ps.setString(1, userDetails.getFname());
//			ps.setString(2, userDetails.getLname());
			ps.setString(1, registerObj.getPassword());
			ps.setString(2, registerObj.getEmail());
			ps.executeUpdate();
			System.out.println("update db :"+registerObj.getPassword());

		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	

	public static boolean executeRetriveQuery(final String email) {
		

		System.out.println("email in db : "+email);
		final String query = "select email , password from license_registration where email = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			System.out.println("mail after set :"+email);
			ResultSet resultSet = ps.executeQuery();
			System.out.println("retrive :"+ query);
			if(resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static String executeRetriveQuery(String email,String password) {

		final String query = "select firstName from license_registration where email = ? and password = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet resultSet = ps.executeQuery();
			System.out.println("login : "+resultSet);
			if(resultSet.next()) {				
				return resultSet.getString("firstName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	

	
	
	

}


