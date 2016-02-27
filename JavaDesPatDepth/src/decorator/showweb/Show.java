package decorator.showweb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import db.connection.DbProc;

public class Show implements IShow {

	HttpServletRequest req;
	int pagesize = 10;
	int page;
	int pagetotal;
	String strSQL;
	String title[];
	String width[];

	@Override
	public int getPage() {
		return page;
	}

	@Override
	public int getTotal() {
		return pagetotal;
	}

	private void getInfo() {
		strSQL = req.getParameter("strsql");
		page = Integer.parseInt(req.getParameter("page"));
		title = req.getParameterValues("title");
		width = req.getParameterValues("width");
	}

	@Override
	public String show(HttpServletRequest req) throws Exception {
		this.req = req;
		getInfo();

		DbProc dbobj = new DbProc();
		Connection conn = dbobj.connect();

		int pos = strSQL.indexOf("from");
		String subs = strSQL.substring(pos, strSQL.length());
		String s = "select count(*) " + subs;
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(s);
		int total = 0;
		if (!rst.next())
			total = 0;
		else
			total = rst.getInt(1);
		rst.close();

		int pagetotal = total / pagesize;
		if (total % pagesize != 0)
			pagetotal++;
		if (page > pagetotal)
			page = pagetotal;
		int start = (page - 1) * pagesize;
		s = strSQL + " limit " + start + "," + pagesize;

		rst = stm.executeQuery(s);
		s = "<table border='1'>";

		String subhead = "<tr>";
		for (int i = 0; i < title.length; i++) {
			subhead += "<th width='" + width[i] + "'>" + title[i] + "</th>";
		}
		subhead += "</tr>";

		subs = "";
		while (rst.next()) {
			subs += "<tr>";
			for (int i = 1; i <= title.length; i++) {
				subs += "<td>" + rst.getString(i) + "</td>";
			}
			subs += "</tr>";
		}
		s += subhead;
		s += subs;
		s += "</table>";
		rst.close();
		stm.close();
		return s;
	}

}
