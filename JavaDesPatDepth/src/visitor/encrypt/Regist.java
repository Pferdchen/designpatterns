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
 * Servlet implementation class Regist
 */
@WebServlet("/Regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Regist() {
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse rep)
			throws ServletException, IOException {
		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");
		String type = req.getParameter("type");

		IVisitor v = new EncryptVisitor();
		User u = new User(user, pwd, Integer.parseInt(type));
		u.encrypt(v);

		String result = "register success";
		try {
			String strSQL = "select * from login where user='" + u.user + "'";
			DbProc dbobj = new DbProc();
			Connection conn = dbobj.connect();
			Statement stm = conn.createStatement();
			ResultSet rst = stm.executeQuery(strSQL);
			if (rst.next())
				result = "register failare";
			else {
				strSQL = "insert into login values('" + u.user + "'," + "'"
						+ u.pwd + "'," + u.type + ")";
				stm.executeUpdate(strSQL);
			}
			rst.close();
			stm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		rep.getWriter().print(result);
	}
}
