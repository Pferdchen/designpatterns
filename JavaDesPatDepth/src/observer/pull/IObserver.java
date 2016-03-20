package observer.pull;

public interface IObserver {

	public int getMark();

	public void refresh(ISubject subject);

}
