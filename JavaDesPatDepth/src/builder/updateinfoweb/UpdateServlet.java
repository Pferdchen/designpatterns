package builder.updateinfoweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		request.getSession().setAttribute("user", "1001");

		int type = Integer.parseInt(request.getParameter("mytype"));
		String accountNO = request.getParameter("user");
		IWebBuild obj = null;
		switch (type) {
		case 1:
			obj = new StudentWebBuild();
			break;
		case 2:
			obj = new TeacherWebBuild();
			break;
		}
		Director direct = new Director(obj);
		String s = direct.build(accountNO);
		
		s += "<input type='hidden' id='account' value='" + accountNO + "'/>";
		
		PrintWriter out = response.getWriter();
		out.print(s);
	}
}
