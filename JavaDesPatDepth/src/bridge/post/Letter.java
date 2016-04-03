package bridge.post;

public class Letter extends AbstractThing {

	/**
	 * default constructor, used for reflection newInstance()
	 */
	public Letter() {
		super();
	}
	
	public Letter(IPost obj) {
		super(obj);
	}

	public Letter(String reflectName) throws Exception {
		super(reflectName);
		// TODO Auto-generated constructor stub
	}

}
