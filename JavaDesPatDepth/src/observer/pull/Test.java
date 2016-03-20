package observer.pull;

public class Test {

	public static void main(String[] args) {
		Subject subject = new Subject();
		subject.register("observer.xml");
		subject.setData("hello");
		subject.notifyObservers();
	}

}
