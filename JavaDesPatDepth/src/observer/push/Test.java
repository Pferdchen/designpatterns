package observer.push;

public class Test {

	public static void main(String[] args) {
		IObserver obs = new Observer();
		Subject subject = new Subject();
		subject.register(obs);
		subject.setData("hello");
		subject.notifyObservers();
	}

}
