package observer.push;

import java.util.Vector;

public class Subject implements ISubject<Object> {

	private Vector<IObserver> vec = new Vector<>();

	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public void register(IObserver obs) {
		if (!vec.contains(obs))
			vec.add(obs);
	}

	@Override
	public void unregister(IObserver obs) {
		if (vec.contains(obs))
			vec.remove(obs);
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < vec.size(); i++) {
			IObserver obs = vec.get(i);
			obs.refresh(data);
		}
	}

}
