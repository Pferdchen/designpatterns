package state.memory;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.ManagementFactory;

import javax.swing.JFrame;
import javax.swing.Timer;

import com.sun.management.OperatingSystemMXBean;

public class MyFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	CtrlPanel ctrlPanel = new CtrlPanel();
	ContentPanel contentPanel = new ContentPanel();
	StatePanel statePanel = new StatePanel();
	Timer timer = new Timer(1000, this);
	int high, mid;

	public void init() {
		add(ctrlPanel, BorderLayout.NORTH);
		add(contentPanel, BorderLayout.CENTER);
		add(statePanel, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 220);
		setVisible(true);
	}

	public void startMonitor(int high, int mid) {
		this.high = high;
		this.mid = mid;
		timer.start();
	}

	public void stopMonitor() {
		timer.stop();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		long total = osmxb.getTotalPhysicalMemorySize();
		long free = osmxb.getFreePhysicalMemorySize();
		int ratio = (int) (free * 100L / total);
		contentPanel.setValue(total, free, ratio);

		int mark = -1;
		if (ratio >= high)
			mark = 1;
		else if (ratio < mid)
			mark = 3;
		else
			mark = 2;

		statePanel.setState(mark);
		statePanel.process();
	}

	public static void main(String[] args) throws Exception {
		new MyFrame().init();
	}
	
}
