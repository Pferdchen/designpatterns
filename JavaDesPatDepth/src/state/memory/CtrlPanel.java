package state.memory;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CtrlPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	JComponent c[] = { new JTextField(4), new JTextField(4), new JButton("Start Listening"),
			new JButton("Stop Listening") };

	boolean bmark[][] = { { true, true, true, false }, { false, false, false, true } };

	ActionListener startAct = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setState(1);
			int high = Integer.parseInt(((JTextField) c[0]).getText());
			int low = Integer.parseInt(((JTextField) c[1]).getText());
			Container c = CtrlPanel.this.getParent();
			String className = c.getClass().getName();
			while (!className.equals("state.memory.MyFrame")) {
				c = c.getParent();
				className = c.getClass().getName();
			}
			((MyFrame) c).startMonitor(high, low);
		}
	};

	ActionListener stopAct = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setState(0);
			Container c = CtrlPanel.this.getParent();
			String className = c.getClass().getName();
			while (!className.equals("state.memory.MyFrame")) {
				c = c.getParent();
				className = c.getClass().getName();
			}
			((MyFrame) c).stopMonitor();
		}
	};

	public CtrlPanel() {
		add(new JLabel("Very good"));
		add(c[0]);
		add(new JLabel("good"));
		add(c[1]);
		add(c[2]);
		add(c[3]);
		setState(0);

		((JButton) c[2]).addActionListener(startAct);
		((JButton) c[3]).addActionListener(stopAct);
	}

	void setState(int nState) {
		for (int i = 0; i < bmark[nState].length; i++) {
			c[i].setEnabled(bmark[nState][i]);
		}
	}

}
