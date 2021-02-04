

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedbackInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public FeedbackInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String r1 = request.getParameter("r1");
		String r2 = request.getParameter("r2");
		String r3 = request.getParameter("r3");
		String r4 = request.getParameter("r4");
		String r5 = request.getParameter("r5");
		
		FeedbackBean fb = new FeedbackBean();
		fb.setR1(r1);
		fb.setR2(r2);
		fb.setR3(r3);
		fb.setR4(r4);
		fb.setR5(r5);
		
		FeedbackDAO dao = new FeedbackDAO();
		
		try {
			int i = dao.Insert(fb);
			if(i>0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("FeedbackDisplay");
				request.setAttribute("feedbackbean", fb);
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("error2.html"); 
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
