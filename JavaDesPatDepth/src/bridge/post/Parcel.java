package bridge.post;

public class Parcel extends AbstractThing {

	/**
	 * default constructor, used for reflection newInstance()
	 */
	public Parcel() {
	}

	public Parcel(IPost obj) {
		super(obj);
	}

	public Parcel(String reflectName) throws Exception {
		super(reflectName);
		// TODO Auto-generated constructor stub
	}

}
