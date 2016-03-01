package visitor.encrypt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.connection.DbProc;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse rep)
			throws ServletException, IOException {
		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");
		IVisitor v = new EncryptVisitor();
		User u = new User(user, pwd);
		u.encrypt(v);

		String result = "login success";
		try {
			String strSQL = "select * from login where user='" + u.user + "'"
					+ " and pwd='" + u.pwd + "'";
			DbProc dbobj = new DbProc();
			Connection conn = dbobj.connect();
			Statement stm = conn.createStatement();
			ResultSet rst = stm.executeQuery(strSQL);
			if (!rst.next())
				result = "login failare";
			rst.close();
			stm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		rep.getWriter().print(result);
	}

}
