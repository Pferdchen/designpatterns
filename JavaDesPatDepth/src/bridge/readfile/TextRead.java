package bridge.readfile;

public class TextRead implements IRead<String> {

	AbstractStream stream;

	public TextRead(AbstractStream stream) {
		this.stream = stream;
	}

	@Override
	public String read() throws Exception {
		byte buf[] = stream.readBytes();
		String s = new String(buf);
		return s;
	}

}
