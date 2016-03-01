package command.multithreads;

public class ShowReceive implements IReceiver {

	@Override
	public void process(ISource src) {
		Msgsrc obj = (Msgsrc) src;
		System.out.println(obj.getMsg());
	}

}
