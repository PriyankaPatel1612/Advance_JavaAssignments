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
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 
		 int partyId=Integer.parseInt(request.getParameter("id"));
		 
		 int status=0;
		
		 try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerregistration","root","root");			
				PreparedStatement ps = con.prepareStatement("DELETE FROM party WHERE partyId=? ");
	
				ps.setInt(1, partyId);
				
				status= ps.executeUpdate();
				
				if(status>0) {
					out.print("<p>Record deleted successfully!</p>");
					
					request.getRequestDispatcher("homePage.jsp").include(request,response);
								
				}else {
					
					out.print("<p>Unable to delete record,Please Retry</p>");
					request.getRequestDispatcher("update.html");
					
				}
				
		 }catch(Exception e) {
				e.printStackTrace();
			}

		 }

}
