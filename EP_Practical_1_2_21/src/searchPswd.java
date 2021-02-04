import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class searchPswd extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public searchPswd() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("emailid");
		String pswd = request.getParameter("pswd");
		
		LoginBean lb = new LoginBean();
		lb.setEmail(email);
		lb.setPswd(pswd);
		
		loginDAO log = new loginDAO();
		String s = "";
		
		try {
			s = s+log.search(email);
			
			if(s.equals(pswd)){
				RequestDispatcher rd = request.getRequestDispatcher("feedback.html"); //the argument can be html or servlet or jsp
				rd.include(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("error1.html"); //the argument can be html or servlet or jsp
				rd.include(request, response);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}
}
