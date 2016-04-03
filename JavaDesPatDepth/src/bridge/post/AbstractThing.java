package bridge.post;

public class AbstractThing {

	private IPost obj;

	public AbstractThing() {
	}

	public AbstractThing(IPost obj) {
		this.obj = obj;
	}

	public void post() {
		this.obj.post();
	}

	public AbstractThing(String reflectName) throws Exception {
		this.obj = (IPost) Class.forName(reflectName).newInstance();
	}

	public void createPost(String funcName) throws Exception {
		this.obj = (IPost) Class.forName(funcName).newInstance();
	}

}
