package builder.dataimport;

import java.io.File;
import java.io.RandomAccessFile;

public class BinaryBuild extends AbstractBuild {

	int unitsize[] = { 10, 10, 2 };
	RandomAccessFile in;
	long fileLength;
	long current;
	byte buffer[];

	public BinaryBuild() {
		int size = 0;
		for (int i = 0; i < unitsize.length; i++)
			size += unitsize[i];
		buffer = new byte[size];
	}

	@Override
	public boolean open(String strPath) {
		try {
			File file = new File(strPath);
			in = new RandomAccessFile(file, "rw");
			fileLength = file.length();
		} catch (Exception e) {
		}
		return true;
	}

	@Override
	public boolean hastNext() {
		return current < fileLength;
	}

	@Override
	public Score next() {
		Score obj = new Score();
		try {
			in.read(buffer);
			current += buffer.length;
			obj.setStudno(new String(buffer, 0, 10));
			int n = 10;
			while (buffer[n] != 0)
				n++;
			obj.setName(new String(buffer, 10, n));
			obj.setScore((int) buffer[21] * 256 + buffer[20]);
		} catch (Exception e) {
		}
		return obj;
	}

	@Override
	public void close() {
		try {
			in.close();
		} catch (Exception e) {
		}
	}

}
