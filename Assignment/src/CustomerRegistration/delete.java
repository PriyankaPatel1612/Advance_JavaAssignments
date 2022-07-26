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
public class Delete extends HttpServlet {
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
				PreparedStatement ps1 = con.prepareStatement("DELETE FROM userlogin WHERE partyId=? ");
	
				ps.setInt(1, partyId);
				ps1.setInt(1, partyId);
				
				status= ps1.executeUpdate();
				status= ps.executeUpdate();
				
				if(status>0) {
					out.println("<script type=\"text/javascript\">");
		            out.println("alert('Record deleted successfully!');");
		            out.println("</script>");
					
					
					request.getRequestDispatcher("delete.jsp").include(request,response);
								
				}else {
					out.println("<script type=\"text/javascript\">");
		            out.println("alert('Unable to delete record,Please Retry');");
		            out.println("</script>");
		            
					
					request.getRequestDispatcher("delete.jsp").include(request,response);
					
				}
				
		 }catch(Exception e) {
				e.printStackTrace();
			}

		 }

}
