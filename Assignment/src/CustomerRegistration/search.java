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



@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor\" crossorigin=\"anonymous\"></linl>");
		out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2\" crossorigin=\"anonymous\"></script>");
		
		out.println("<div class=\"vh-100 bg-primary p-2 text-dark\">");
		out.println("<h1 class=\"text-centre\">Customer Record<h1>");
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerregistration","root","root");
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM party WHERE firstName=? AND lastName=?");
			
			ps.setString(1,fname);
			ps.setString(2,lname);
			
			out.print("<table class=\"table table-dark table-striped\" class=\"table table-bordered\" width=75% border=1>");
			out.print("<caption> Customer Name: </caption>");
			
			ResultSet rs = ps.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int totalColumn = rsmd.getColumnCount();
			out.print("<tr class=\"table-light\">");
			for(int i=1 ; i<=totalColumn ;i++)
			{
				out.print("<th class=\"table-light\">"+rsmd.getColumnName(i)+"</th>");
		     }
			
			out.print("</tr>");
			while(rs.next()) {
				
				out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getInt(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getInt(9));
			}
			out.print("</table>");
			
			
		}catch(Exception e) {
			out.print(e);
		}
		out.println("</div>");
		out.println("</section>");
	}

}
