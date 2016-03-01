package command.multithreads;

public class EmailReceive implements IReceiver {

	@Override
	public void process(ISource src) {
		System.out.println("this is Email process");
	}

}
