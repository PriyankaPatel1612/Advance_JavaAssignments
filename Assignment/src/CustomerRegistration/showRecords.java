package CustomerRegistration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/showRecords")
public class ShowRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor\" crossorigin=\"anonymous\"></linl>");
		out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2\" crossorigin=\"anonymous\"></script>");
		
		
		out.println("<div class=\"vh-100 bg-primary p-2 text-dark\">");
		out.println("<h1 class=\"h1\"><strong>Customer Records</strong></h1>");
		
				
		out.println("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\" >\r\n"
				+ "         <div class=\"container-fluid\">\r\n"
				            
				+ "         <a  type=\"button\" class=\"btn btn-light\"   href=\"homePage.jsp\">Back</a>\r\n"	
			
				+ "         <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n"
				+ "         <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\"></ul>\r\n"
				+ "         <form class=\"d-flex\" role=\"search\" action=\"search\" method=\"post\">\r\n"
				+ "          \r\n"
				+ "          <a  class=\"btn btn-outline-light\" href=\"search.jsp\" >Search</a>\r\n"
				+ "          \r\n"
				+ "          </form>   \r\n"
				
				+ "       <form class=\"d-flex\" role=\"update\" action=\"update\" method=\"post\">\r\n"
				+ "        \r\n"
				+ "        <a  class=\"btn btn-outline-light\" href=\"update.jsp\" >Update</a>\r\n"
				+ "        \r\n"
				+ "      </form>   \r\n"
				        
				+ "       <form class=\"d-flex\" role=\"delete\" action=\"delete\" method=\"post\">\r\n"
				+ "        \r\n"
				+ "        <a  class=\"btn btn-outline-light\" href=\"delete.jsp\" >Delete</a>\r\n"
				+ "        \r\n"
				+ "      </form>   \r\n"
				
				+ "      </div>\r\n"
				+ "   </div>\r\n"
				+ "</nav>\r\n"
				+ "");
		
		
		try {
			
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerregistration","root","root");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM party");
			
			out.print("<table class=\"table table-dark table-striped\" class=\"table table-bordered\" width=75% border=1>");
			
			
			ResultSet rs = ps.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int totalColumn = rsmd.getColumnCount();
			
			
				
				 out.print("<tr class=\"table-light\">");
				
				 out.print(("<th class=\"table-light\">S.No.</th>"));
				 out.print(("<th class=\"table-light\">First Name</th>"));
				 out.print(("<th class=\"table-light\">Last Name</th>"));
				 out.print(("<th class=\"table-light\">Address</th>"));
				 out.print(("<th class=\"table-light\">City</th>"));
				 out.print(("<th class=\"table-light\">Zip</th>"));
				 out.print(("<th class=\"table-light\">State</th>"));
				 out.print(("<th class=\"table-light\">Country</th>"));
				 out.print(("<th class=\"table-light\">Phone No.</th>"));
			
				out.print("</tr>");
				while(rs.next()) {
					out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getInt(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td></tr>");
					
				}
				out.print("</table>");
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		out.println("</div>");
		out.println("</section>");
	}

}
