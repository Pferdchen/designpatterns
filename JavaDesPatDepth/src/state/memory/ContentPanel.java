package state.memory;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class ContentPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	JTextField totalField = new JTextField(20);
	JTextField freeField = new JTextField(20);
	JTextField ratioField = new JTextField(8);

	public ContentPanel() {
		totalField.setEnabled(false);
		freeField.setEnabled(false);
		ratioField.setEnabled(false);

		Box b1 = Box.createVerticalBox();
		b1.add(new JLabel("Total Memory:"));
		b1.add(Box.createVerticalStrut(16));
		b1.add(new JLabel("Free Memory"));
		b1.add(Box.createVerticalStrut(16));
		b1.add(new JLabel("Ratio"));
		b1.add(Box.createVerticalStrut(16));

		Box b2 = Box.createVerticalBox();
		b2.add(totalField);
		b2.add(Box.createVerticalStrut(16));
		b2.add(freeField);
		b2.add(Box.createVerticalStrut(16));
		b2.add(ratioField);
		b2.add(Box.createVerticalStrut(16));

		add(b1);
		add(b2);
		setBorder(new BevelBorder(BevelBorder.RAISED));
	}

	public void setValue(long total, long free, int ratio) {
		totalField.setText("" + total);
		freeField.setText("" + free);
		ratioField.setText("" + ratio + "%");
	}

}
