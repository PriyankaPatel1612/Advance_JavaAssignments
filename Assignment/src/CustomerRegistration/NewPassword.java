package CustomerRegistration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/NewPassword")
public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NewPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String newPassword = request.getParameter("newpwd");
		String confPassword = request.getParameter("confirmpwd");
		
		RequestDispatcher dispatcher = null;
		if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerregistration","root","root");
				PreparedStatement pst = con.prepareStatement("UPDATE userlogin SET password=? WHERE userLoginId=? ");
				pst.setString(1, newPassword);
				pst.setString(2, (String) session.getAttribute("email"));

				int rowCount = pst.executeUpdate();
				
				if (rowCount > 0) {
					request.setAttribute("status", "Password reset successfully");
					dispatcher = request.getRequestDispatcher("newPassword.jsp");
				} else {
					request.setAttribute("status", "Unable to reset password, Please try again.");
					dispatcher = request.getRequestDispatcher("newPassword.jsp");
				}
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
