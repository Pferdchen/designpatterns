package observer.jdk;

import java.util.Observable;

public class Subject extends Observable {

	String data;

	Object factor;

	public void setFactor(Object factor) {
		this.factor = factor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
		setChanged();
		notifyObservers(factor);
	}
}
