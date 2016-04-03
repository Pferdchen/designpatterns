package bridge.bsshow;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SalaryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SalaryServlet() {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		String emno = request.getParameter("emno");
		int type = Integer.parseInt(request.getParameter("type"));
		IPara para = new SalaryPara();
		AbstractShow show = null;
		switch (type) {
		case 1:
			show = new TableShow();
			break;
		case 2:
			show = new GraphShow();
			break;
		}

		show.setPara(para);
		AbstractThing thing = new Employee(show);

		String s = "";
		try {
			s = thing.show(emno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().print(s);
	}
}
