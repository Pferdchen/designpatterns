package bridge.post;

public class SimplePost implements IPost {

	@Override
	public void post() {
		System.out.println("This is Simple post");
	}

}
