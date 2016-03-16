package builder.updateinfo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import db.connection.DbProc;

public class StudentBuilder extends UIBuilder implements ActionListener {

	String user;
	JTextField studName = new JTextField(10);
	JTextField studAge = new JTextField(10);
	JTextField studMajor = new JTextField(10);
	JTextField studDepart = new JTextField(10);
	JButton updateBtn = new JButton("Update");

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String name = studName.getText();
		String age = studAge.getText();
		String major = studMajor.getText();
		String depart = studDepart.getText();
		String strSQL = "update student set name='" + name + "', age=" + age// age?
				+ ", major='" + major + "', depart='" + depart + "'" + " where user='" + user + "'";

		try {
			DbProc dbobj = new DbProc();
			dbobj.connect();
			dbobj.executeUpate(strSQL);
			dbobj.close();
		} catch (Exception e) {
		}
	}

	@Override
	public void addUI() {
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		Box b = Box.createVerticalBox();
		b.add(new JLabel("Name"));
		b.add(Box.createVerticalStrut(8));
		b.add(new JLabel("Age"));
		b.add(Box.createVerticalStrut(8));
		b.add(new JLabel("Major"));
		b.add(Box.createVerticalStrut(8));
		b.add(new JLabel("Department"));
		b.add(Box.createVerticalStrut(8));
		Box b2 = Box.createVerticalBox();
		b2.add(studName);
		b2.add(Box.createVerticalStrut(8));
		b2.add(studAge);
		b2.add(Box.createVerticalStrut(8));
		b2.add(studMajor);
		b2.add(Box.createVerticalStrut(8));
		b2.add(studDepart);
		b2.add(Box.createVerticalStrut(8));
		center.add(b);
		center.add(b2);
		south.add(updateBtn);
		panel.setLayout(new BorderLayout());
		panel.add(center, BorderLayout.CENTER);
		panel.add(south, BorderLayout.SOUTH);
	}

	@Override
	public void registerMsg() {
		updateBtn.addActionListener(this);
	}

	@Override
	public void initialData(String user1) {
		this.user = user1;
		String strSQL = "select name, age, major, depart from student where user='" + user + "'";
		DbProc dbobj = new DbProc();
		try {
			dbobj.connect();
			List<Vector<Object>> l = (List) dbobj.executeQuery(strSQL);
			Vector<Object> v = (Vector<Object>) l.get(0);
			studName.setText((String) v.get(0));
			studAge.setText((String) v.get(1));
			studMajor.setText((String) v.get(2));
			studDepart.setText((String) v.get(3));
			dbobj.close();
		} catch (Exception e) {
		}
	}

}
