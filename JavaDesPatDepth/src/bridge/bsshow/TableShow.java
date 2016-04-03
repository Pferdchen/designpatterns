package bridge.bsshow;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import db.connection.DbProc;

public class TableShow extends AbstractShow {

	private String getHeader() {
		String title[] = para.getTitle();
		String s = "<tr>";
		for (int i = 0; i < title.length; i++) {
			s += "<th>" + title[i] + "</th>";
		}
		s += "</tr>";
		return s;
	}

	private String getData(String no) throws Exception {
		String s = "";
		String strSQL = para.getPreSQL() + "'" + no + "'";
		DbProc dbobj = new DbProc();
		Connection conn = dbobj.connect();
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(strSQL);
		if (rst.next()) {
			s += "<tr>";
			for (int i = 0; i < para.getTitle().length; i++) {
				s += "<td>" + rst.getString(i + 1) + "</td>";
			}
			s += "</tr>";
		}

		stm.close();
		conn.close();
		return s;
	}

	@Override
	public String show(String no) throws Exception {
		String s = "<table border='1'>";
		s += getHeader();
		s += getData(no);
		s += "</table>";
		return s;
	}

}
