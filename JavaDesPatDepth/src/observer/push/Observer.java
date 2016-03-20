package observer.push;

public class Observer implements IObserver<Object> {

	@Override
	public void refresh(Object data) {
		System.out.println("I have received the data:" + (String) data);
	}

}
