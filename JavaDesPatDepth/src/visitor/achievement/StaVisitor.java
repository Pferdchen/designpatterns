package visitor.achievement;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StaVisitor implements IVisitor {

	@Override
	public void visit(Banji obj, JPanel panel) {
		String title[] = { "Grade interval", "Number of people" };
		String d[][] = new String[11][2];
		d[0][0] = "<200";

		for (int i = 1; i < d.length; i++)
			d[i][0] = "" + (200 + (i - 1) * 10) + "~" + (200 + (i * 10));

		int num[] = new int[11];
		Vector<Student> v = obj.getV();

		for (int i = 0; i < v.size(); i++) {
			Student s = v.get(i);
			int total = s.chinese + s.math + s.english;
			if (total < 200)
				num[0]++;
			else
				num[(total - 200) / 10 + 1]++;
		}

		for (int i = 0; i < num.length; i++) {
			d[i][1] = "" + num[i];
		}

		panel.removeAll();
		panel.setLayout(new BorderLayout());
		JTable tab = new JTable(d, title);
		JScrollPane scr = new JScrollPane(tab);
		panel.add(scr);
		panel.updateUI();
	}

}
