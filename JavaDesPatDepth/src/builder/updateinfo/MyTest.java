package builder.updateinfo;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyTest {

	public static void main(String[] args) {
		JFrame frm = new JFrame();
		UIBuilder ub = new StudentBuilder();
		Director direct = new Director(ub);
		JPanel panel = direct.build("1001");
		frm.add(panel);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.pack();
		frm.setVisible(true);
	}

}
