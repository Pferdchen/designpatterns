package bridge.post;

public class NewThing extends AbstractThing {

	/**
	 * default constructor, used for reflection newInstance()
	 */
	public NewThing() {
	}
	
	public NewThing(IPost obj) {
		super(obj);
	}

	public NewThing(String reflectName) throws Exception {
		super(reflectName);
		// TODO Auto-generated constructor stub
	}

}
