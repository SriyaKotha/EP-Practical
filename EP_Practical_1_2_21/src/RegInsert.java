import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegInsert() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int regno = Integer.parseInt(request.getParameter("regno"));
		String name = request.getParameter("StdName");
		String email = request.getParameter("emailid");
		String pswd = request.getParameter("pswd");
		int year = Integer.parseInt(request.getParameter("year"));
		int sec = Integer.parseInt(request.getParameter("sec"));
		
		RegBean rb = new RegBean();
		rb.setRegno(regno);
		rb.setName(name);
		rb.setEmail(email);
		rb.setPswd(pswd);
		rb.setYear(year);
		rb.setSec(sec);
		
		RegDAO dao = new RegDAO(); 
		
		try {
			int i = dao.studentInsert(rb);
			if(i>0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("feedback.html"); //the argument can be html or servlet or jsp
				rd.include(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("error.html"); //the argument can be html or servlet or jsp
				rd.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	}
}
