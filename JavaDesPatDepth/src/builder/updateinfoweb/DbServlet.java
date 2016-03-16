package builder.updateinfoweb;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.connection.DbProc;

public class DbServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;

	public DbServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String strsql = request.getParameter("strsql");
		DbProc obj = new DbProc();
		try {
			obj.connect();
			obj.executeUpate(strsql);
			obj.close();
		} catch (Exception e) {
		}
	}
}
