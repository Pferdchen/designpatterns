package bridge.readfile;

public class ImgRead implements IRead<byte[]> {

	AbstractStream stream;

	public ImgRead(AbstractStream stream) {
		this.stream = stream;
	}

	@Override
	public byte[] read() throws Exception {
		return stream.readBytes();
	}

}
