package bridge.post;

public class AbstractThing {

	private IPost obj;

	public AbstractThing(IPost obj) {
		this.obj = obj;
	}

	public void post() {
		obj.post();
	}

}
