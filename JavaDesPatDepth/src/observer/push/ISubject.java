package observer.push;

public interface ISubject<T> {

	public void register(IObserver<T> obs);

	public void unregister(IObserver<T> obs);

	public void notifyObservers();

}
