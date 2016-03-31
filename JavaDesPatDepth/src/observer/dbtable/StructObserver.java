package observer.dbtable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import db.connection.DbProc;

public class StructObserver implements Observer {

	private JTable table;

	public StructObserver(JTable table) {
		this.table = table;
	}

	@Override
	public void update(Observable o, Object arg) {
		Subject subject = (Subject) o;
		String strSQL = "select * from " + subject.getTableName();
		DbProc dbobj = new DbProc();
		try {
			Connection conn = dbobj.connect();
			Statement stm = conn.createStatement();
			ResultSet rst = stm.executeQuery(strSQL);
			ResultSetMetaData rsmd = rst.getMetaData();
			String title[] = { "Field Name", "Type", "Size" };
			String data[][] = new String[rsmd.getColumnCount()][title.length];
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				data[i][0] = rsmd.getColumnName(i + 1);
				data[i][1] = "" + rsmd.getColumnType(i + 1);
				data[i][2] = "" + rsmd.getPrecision(i + 1);
			}
			stm.close();
			conn.close();

			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.setDataVector(data, title);
		} catch (Exception e) {
		}
	}

}
