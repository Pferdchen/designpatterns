package state.memory;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	JTextField txtInfo = new JTextField(4);
	JTextField txtHour = new JTextField(10);
	IState state;
	int mark = -1;

	public StatePanel() {
		add(new JLabel("Current Memory State:"));
		add(txtInfo);
		add(new JLabel("Duration"));
		add(txtHour);
		txtInfo.setEnabled(false);
		txtHour.setEnabled(false);
	}

	public void setState(int mark) {
		if (this.mark == mark)
			return;
		this.mark = mark;

		switch (mark) {
		case 1:
			state = new HighState();
			break;
		case 2:
			state = new MidState();
			break;
		case 3:
			state = new LowState();
			break;
		}
	}

	public void process() {
		txtInfo.setText(state.getStateInfo());
		int size = state.getStateInterval();
		txtHour.setText("" + (float) size / 3600);
	}
}
