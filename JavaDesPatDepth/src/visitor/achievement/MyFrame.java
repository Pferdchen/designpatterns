package visitor.achievement;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MyFrame extends JFrame {
	Grade grade = new Grade();
	JPanel contentPane = new JPanel();
	JComboBox combo;

	ActionListener al = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String factor = (String) combo.getSelectedItem();
			Banji obj = (Banji) grade.map.get(factor);
			Vector<Student> v = obj.getV();
			String title[] = { "StudNo", "Name", "Chinese", "Math", "English" };
			String d[][] = new String[v.size()][5];
			for (int i = 0; i < v.size(); i++) {
				Student unit = v.get(i);
				d[i][0] = unit.studNO;
				d[i][1] = unit.name;
				d[i][2] = "" + unit.chinese;
				d[i][3] = "" + unit.math;
				d[i][4] = "" + unit.english;
			}
			showTable(d, title);
		}
	};

	ActionListener a2 = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String factor = (String) combo.getSelectedItem();
			Banji obj = (Banji) grade.map.get(factor);
			Vector<Student> v = obj.getV();
			obj.statistics(new StaVisitor(), contentPane);
		}
	};

	public void showTable(String d[][], String title[]) {
		contentPane.removeAll();
		contentPane.setLayout(new BorderLayout());
		JTable tab = new JTable(d, title);
		JScrollPane scr = new JScrollPane(tab);
		contentPane.add(scr);
		contentPane.updateUI();
	}

	public void init(String strFile) {
		grade.readFile(strFile);
		setLayout(null);
		Set<String> set = grade.map.keySet();
		Object info[] = set.toArray();
		combo = new JComboBox(info);
		combo.setBounds(10, 10, 150, 30);
		add(combo);

		JButton dispBtn = new JButton("Show grade");
		JButton infoBtn = new JButton("Statistic");
		dispBtn.addActionListener(al);
		infoBtn.addActionListener(a2);
		dispBtn.setBounds(10, 60, 150, 30);
		infoBtn.setBounds(10, 110, 150, 30);
		add(dispBtn);
		add(infoBtn);

		contentPane.setBounds(170, 10, 420, 280);
		contentPane.setBorder(BorderFactory.createEtchedBorder());
		add(contentPane);

		this.setSize(600, 320);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
