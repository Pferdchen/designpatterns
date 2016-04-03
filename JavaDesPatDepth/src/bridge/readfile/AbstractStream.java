package bridge.readfile;

import java.io.InputStream;

public class AbstractStream {

	protected InputStream in;
	protected int size;

	protected byte[] readBytes() throws Exception {
		byte buf[] = new byte[size];
		in.read(buf);
		return buf;
	}

	public void close() throws Exception {
		in.close();
	}

}
