package proxy.virtual;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import db.connection.DbProc;

public class ManageItems {

	Vector<ProxyItem> v = new Vector<ProxyItem>();

	public void firstSearch() throws Exception {
		String strSQL = "select account, name, project from project";
		DbProc dbobj = new DbProc();
		Connection conn = dbobj.connect();
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(strSQL);
		while (rst.next()) {
			ProxyItem obj = new ProxyItem(new RealItem());
			obj.setAccount(rst.getString("account"));
			obj.setName(rst.getString("name"));
			obj.setProject(rst.getString("project"));
			v.add(obj);
		}
		rst.close();
		stm.close();
		conn.close();
	}

}
