package CustomerRegistration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int partyId=Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String address = request.getParameter("address");
		String city = request.getParameter("city");			
		int zip = Integer.parseInt(request.getParameter("zip"));
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		int phone  = Integer.parseInt(request.getParameter("phone"));
		String userLoginId = request.getParameter("email");
		String password = request.getParameter("password");
		
		int status=0;
		
		try {
			
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerregistration","root","root");			
		PreparedStatement ps1 = con.prepareStatement("UPDATE party SET firstName=\"?\", lastName=\"?\", address=\"?\", city=\"?\", zip=\"?\", state=\"?\", country=\"?\", phone=\"?\" WHERE partyId=? ");
		
		ps1.setString(1, firstName);
		ps1.setString(2, lastName);
		ps1.setString(3, address);
		ps1.setString(4, city);
		ps1.setInt(5, zip);
		ps1.setString(6, state);
		ps1.setString(7, country);
		ps1.setInt(8, phone);
		ps1.setInt(9, partyId);
		
		PreparedStatement ps2 = con.prepareStatement("UPDATE userlogin SET userLoginId=\"?\", password=\"?\" WHERE partyId=? ");
		ps1.setString(1, userLoginId);
		ps1.setString(2, password);
		ps1.setInt(3, partyId);
		
		status= ps1.executeUpdate();
		status= ps2.executeUpdate();
		
		if(status>0) {
			out.print("<p>Record updated successfully!</p>");
			
			request.getRequestDispatcher("homePage.jsp").include(request,response);
						
		}else {
			
			out.print("<p>Unable to update records,Please Retry</p>");
			request.getRequestDispatcher("update.html").include(request, response);
			
		}
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}

}
}
