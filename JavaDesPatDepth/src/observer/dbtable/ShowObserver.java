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

public class ShowObserver implements Observer {

	private JTable table;

	public ShowObserver(JTable table) {
		this.table = table;
	}

	@Override
	public void update(Observable o, Object arg) {
		Subject subject = (Subject) o;
		String strSQL = "select * from " + subject.getTableName();
		DbProc dbobj = new DbProc();
		try {
			Connection conn = dbobj.connect();
			Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rst = stm.executeQuery(strSQL);
			rst.last();
			int rows = rst.getRow();
			ResultSetMetaData rsmd = rst.getMetaData();

			String title[] = new String[rsmd.getColumnCount()];
			String data[][] = new String[rows][title.length];
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				title[i] = rsmd.getColumnName(i + 1);
			}

			rst.first();
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < title.length; j++)
					data[i][j] = rst.getString(j + 1);
			}
			stm.close();
			conn.close();
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.setDataVector(data, title);
		} catch (Exception e) {
		}
	}

}
