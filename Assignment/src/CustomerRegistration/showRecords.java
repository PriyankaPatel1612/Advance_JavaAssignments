package CustomerRegistration;

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
public class showRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerregistration","root","root");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM party");
			
			out.print("<table wiidth=75% border=1>");
			out.print("<caption>Customer Records</caption><br>");
			
			ResultSet rs = ps.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int totalColumn = rsmd.getColumnCount();
			
			out.print("<tr>");
			
			for(int i=1 ; i<=totalColumn ; i++) {
				
				out.print("<th>"+rsmd.getColumnName(i)+"</th>");
			}
				out.print("</tr>");
				while(rs.next()) {
					out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getInt(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getInt(9)+"</td></tr>");
					
				}
				out.print("</table>");
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}

}
