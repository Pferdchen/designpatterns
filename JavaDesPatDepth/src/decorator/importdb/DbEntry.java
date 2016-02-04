package decorator.importdb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;

import db.connection.DbProc;

public class DbEntry implements IEntry {

	private String tabName;
	private int total;
	private int cursor;

	@Override
	public int getCursor() {
		return cursor;
	}

	@Override
	public int getTotal() {
		return total;
	}

	@Override
	public void entry(String strFile) throws Exception {
		FileReader in = new FileReader(strFile);
		BufferedReader in2 = new BufferedReader(in);
		tabName = in2.readLine();
		total = Integer.parseInt(in2.readLine());

		DbProc dbobj = new DbProc();
		Connection conn = dbobj.connect();
		Statement stm = conn.createStatement();
		String s, strSQL, d[];
		while ((s = in2.readLine()) != null) {
			cursor++;
			d = s.split("\t");
			strSQL = "insert into " + tabName + " values(";
			for (int i = 0; i < d.length; i++) {
				if (i < d.length - 1)
					strSQL += "'" + d[i] + "',";
				else
					strSQL += "'" + d[i] + "')";
			}
			stm.executeUpdate(strSQL);
		}
		stm.close();
		conn.close();
		in2.close();
		in.close();
	}

}
