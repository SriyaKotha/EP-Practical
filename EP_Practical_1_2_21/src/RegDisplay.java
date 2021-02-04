import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegDisplay() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegBean rb = (RegBean) request.getAttribute("regbean");
		PrintWriter pw = response.getWriter();
		pw.print("Welcome "+rb.getName() );
	}

}
