package db.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

public class TestDb {

	private static final String QUERY = "select * from account";

	public static void main(String[] args) throws Exception {
		List<Vector<String>> l = new Vector<Vector<String>>();
		DbProc dbobj = new DbProc();
		Connection conn = dbobj.connect();
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(QUERY);
		ResultSetMetaData rsmd = rst.getMetaData();
		while (rst.next()) {
			Vector<String> unit = new Vector<String>();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				unit.add(rst.getString(i));
			}
			l.add(unit);
		}
		for (int i = 0; i < l.size(); i++) {
			for (int j = 0; j < l.get(i).size(); j++) {
				System.out.println(l.get(i).get(j));
			}
		}
	}

}
