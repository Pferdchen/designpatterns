package observer.jdk;

import java.util.Observer;

public class Test {

	public static void main(String[] args) {
		Subject s = new Subject();
		Observer obj = new OneObserver();
		Observer obj2 = new TwoObserver();
		s.addObserver(obj);
		s.addObserver(obj2);
		s.setFactor("hello");
		s.setData("hello");
		s.setData("how are you");
		s.setData("hello");
		s.setData("thanks");
		System.out.println("The hello times is:" + ((OneObserver) obj).getC());
	}

}
