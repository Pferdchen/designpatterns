package observer.temperature;

public interface ISimuData<T> {
	void open();
	void close();
	boolean hasNext();
	T next();
}
