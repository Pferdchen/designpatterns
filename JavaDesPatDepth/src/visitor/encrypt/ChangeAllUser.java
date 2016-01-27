package visitor.encrypt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.connection.DbProc;

/**
 * Servlet implementation class ChangeAllUser
 */
@WebServlet("/ChangeAllUser")
public class ChangeAllUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeAllUser() {
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			IVisitor v = new EncryptVisitor();
			DbProc dbobj = new DbProc();
			Connection conn = dbobj.connect();
			Statement stm = conn.createStatement();
			ResultSet rst = stm.executeQuery("select * from login");
			Vector vec = new Vector();
			while (rst.next()) {
				User u = new User(rst.getString("user"), rst.getString("pwd"),
						rst.getInt("type"));
				vec.add(u);
			}
			rst.close();
			stm.executeUpdate("delete from login");
			for (int i = 0; i < vec.size(); i++) {
				User u = (User) vec.get(i);
				u.encrypt(v);
				String strSQL = "insert into login values('" + u.user + "',"
						+ "'" + u.pwd + "'," + u.type + ")";
				stm.executeUpdate(strSQL);
			}
			stm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
