package command.multithreads;

public class Msgsrc implements ISource {

	String msg;
	boolean bFire;

	public String getMsg() {
		return msg;
	}

	@Override
	public boolean isbFire() {
		return bFire;
	}

	@Override
	public void setbFire(boolean bFire) {
		this.bFire = bFire;
	}

	public void come(String msg) {
		this.msg = msg;
		if (msg.startsWith("zhang:"))
			bFire = true;
	}

}
