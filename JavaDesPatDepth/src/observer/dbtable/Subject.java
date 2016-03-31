package observer.dbtable;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.Observable;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import db.connection.DbProc;

public class Subject extends Observable implements MouseListener {

	private String tableName;
	private JTable table;

	public Subject(JTable table) throws Exception {
		this.table = table;

		DbProc dbobj = new DbProc();
		Connection conn = dbobj.connect();
		DatabaseMetaData dbmd = conn.getMetaData();
		String s[] = { "table" };
		ResultSet rs = dbmd.getTables(null, null, null, s);
		Vector<String> vec = new Vector<String>();
		while (rs.next())
			vec.add(rs.getString("TABLE_NAME"));
		conn.close();

		String data[][] = new String[vec.size()][1];
		for (int i = 0; i < vec.size(); i++) {
			data[i][0] = vec.get(i);
		}

		String title[] = { "Table Name" };
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setDataVector(data, title);

		table.addMouseListener(this);
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		System.out.println(tableName);
		this.tableName = tableName;
		setChanged();
		notifyObservers();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		setTableName((String) table.getValueAt(row, 0));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
