package command.multithreads;

import java.util.Vector;

public class CommandManage extends Thread {

	Vector<ICommand> v = new Vector<ICommand>();
	ISource src;
	boolean bMark = true;

	public CommandManage(ISource src) {
		this.src = src;
	}

	public void addCommand(ICommand c) {
		v.add(c);
	}

	public void run() {
		while (bMark) {
			if (!src.isbFire())
				continue;
			for (int i = 0; i < v.size(); i++) {
				v.get(i).noticeCommand();
			}
			src.setbFire(false);
		}
	}

}
