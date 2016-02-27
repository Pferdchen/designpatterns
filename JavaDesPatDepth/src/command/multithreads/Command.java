package command.multithreads;

public class Command implements ICommand {

	IReceiver rvr;
	ISource src;

	public Command(IReceiver rvr, ISource src) {
		this.rvr = rvr;
		this.src = src;
	}

	@Override
	public void noticeCommand() {
		rvr.process(src);
	}

}
