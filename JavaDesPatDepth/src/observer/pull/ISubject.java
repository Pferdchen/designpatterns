package observer.pull;

public interface ISubject {

	public void register(String strXMLPath);

	public void unregister(IObserver obs);

	public void notifyObservers();

}
