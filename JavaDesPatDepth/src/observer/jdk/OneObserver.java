package observer.jdk;

import java.util.Observable;
import java.util.Observer;

public class OneObserver implements Observer {

	private int c = 0;
	
	public int getC() {
		return c;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Subject subject = (Subject) o;
		if (subject.getData().equals((String) arg))//arg is factor
				c++;
		//System.out.println("The data is:" + subject.getData());
	}

}
