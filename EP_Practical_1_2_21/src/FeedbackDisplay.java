

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedbackDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FeedbackDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FeedbackBean fb = (FeedbackBean) request.getAttribute("feedbackbean");
		PrintWriter pw = response.getWriter();
		pw.print("1. Gave very informative and interesting classes:"+fb.getR1());
		pw.print("\n2. Was good at explaining things:"+fb.getR2());
		pw.print("\n3. Was effective in leading the Class:"+fb.getR3());
		pw.print("\n4. Stimulated Interest in the class"+fb.getR4());
		pw.print("\nOther Remarks:"+fb.getR5());
	}

}
