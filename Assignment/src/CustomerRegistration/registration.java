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


@WebServlet("/registration")
public class Registration extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerregistration","root","root");
			int partyId=5;
			String firstname = request.getParameter("fname");
			String lastname = request.getParameter("lname");
			String address = request.getParameter("address");
			String city = request.getParameter("city");			
			int zip = Integer.parseInt(request.getParameter("zip"));
			String state = request.getParameter("state");
			String country = request.getParameter("country");
			String phone  = request.getParameter("phone");
			String userLoginId = request.getParameter("email");
			String password = request.getParameter("password");
			
			
			
			PreparedStatement ps1 = con.prepareStatement("insert into party values(?,?,?,?,?,?,?,?,?)");
			ps1.setInt(1, partyId);
			ps1.setString(2, firstname);
			ps1.setString(3, lastname);
			ps1.setString(4, address);
			ps1.setString(5, city);
			ps1.setInt(6, zip);
			ps1.setString(7, state);
			ps1.setString(8, country);
			ps1.setString(9, phone);
			
			
			PreparedStatement ps2 = con.prepareStatement("insert into userLogin values(?,?,?)");
			ps2.setString(1, userLoginId);
			ps2.setString(2, password);
			ps2.setInt(3, partyId);
			
			boolean E1= ps1.execute();
			boolean E2= ps2.execute();
			
			if(E1==false && E2==false) {
				response.setContentType("text/html");
				
				out.println("<script type=\"text/javascript\">");
	            out.println("alert('Registered Sucessfully!');");
	            out.println("</script>");
				
				request.getRequestDispatcher("registration.html").include(request,response);
				
			}else {
				response.setContentType("text/html");
				out.println("<script type=\"text/javascript\">");
	            out.println("alert('Some error occured! \n Try again.');");
	            out.println("</script>");
	            
				
				request.getRequestDispatcher("registration.html").include(request,response);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		
		
		
	}

}
