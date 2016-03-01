package decorator.importdb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JProgressBar;
import javax.swing.Timer;

public class Progress extends Decorator implements Runnable {

	private JProgressBar bar;
	private String strFile;
	private javax.swing.Timer timer;

	public Progress(IEntry obj, String strFile) {
		super(obj);
		this.strFile = strFile;
		timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getTotal() == 0)
					return;
				bar.setValue(getCursor() * 100 / getTotal());
				if (getCursor() == getTotal())
					timer.stop();
			}
		});
	}

	public void setBar(JProgressBar bar) {
		this.bar = bar;
		bar.setStringPainted(true);
	}

	@Override
	public void run() {
		timer.start();
		try {
			super.entry(strFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
