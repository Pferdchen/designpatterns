package observer.pull;

public class Observer2 implements IObserver {

	private final int MARK = 2;

	@Override
	public int getMark() {
		return MARK;
	}

	public boolean equals(Object arg0) {
		Observer obj = (Observer) arg0;
		return obj.getMark() == MARK;
	}

	@Override
	public void refresh(ISubject obj) {
		Subject subject = (Subject) obj;
		System.out.println("I have received observer2 data:" + subject.getData());
	}

}
