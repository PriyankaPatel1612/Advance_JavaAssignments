package CustomerRegistration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/login")
public class login extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(true);
		String userLoginId = request.getParameter("uname");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		
		RequestDispatcher dispatcher =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerregistration", "root", "root");
			PreparedStatement ps = con.prepareStatement("SELECT*FROM userlogin WHERE userLoginId=? AND password=?");
			ps.setString(1, userLoginId);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
		while(rs.next()){
			if(userLoginId.equals(rs.getString(1))) {
				if(password.equals(rs.getString(2))) {
				     session.setAttribute("name",userLoginId);
				     dispatcher=request.getRequestDispatcher("homePage.jsp");
				     dispatcher.forward(request,response);
				     }else {
				    	    out.print("login failed");
							dispatcher = request.getRequestDispatcher("login.html");
							dispatcher.include(request,response);
						}           
			       }
		        }
		
		   }catch (Exception e) {
			e.printStackTrace();
		}
	}
}
