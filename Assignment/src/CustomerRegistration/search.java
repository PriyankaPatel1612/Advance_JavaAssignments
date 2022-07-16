package CustomerRegistration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerregistration","root","root");
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM party WHERE firstName=? AND lastName=?);");
			
			ps.setString(1,fname);
			ps.setString(2,lname);
			
			out.print("<table width=75% border=1>");
			out.print("<caption> Customer Name: </caption>");
			
			ResultSet rs = ps.executeQuery();
			
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			int totalColumn = rsmd.getColumnCount();
			out.print("<tr>");
			for(int i=1 ; i<=totalColumn ;i++)
			{
				out.print("<th>"+rsmd.getColumnName(i)+"</th>");
		     }
			
			out.print("</tr>");
			while(rs.next()) {
				
				out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getInt(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getInt(9)+"</td></tr>");
			}
			out.print("</table>");
			
			
		}catch(Exception e) {
			out.print(e);
		}
	}

}
