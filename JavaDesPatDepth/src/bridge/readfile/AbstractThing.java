package bridge.readfile;

public abstract class AbstractThing {

	IRead<?> read;

	public AbstractThing(IRead<?> read) {
		this.read = read;
	}

	Object read() throws Exception {
		return read.read();
	}

}
