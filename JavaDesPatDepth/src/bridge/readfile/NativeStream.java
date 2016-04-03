package bridge.readfile;

import java.io.File;
import java.io.FileInputStream;

public class NativeStream extends AbstractStream {

	public NativeStream(String strFile) throws Exception {
		File f = new File(strFile);
		size = (int) f.length();
		in = new FileInputStream(f);
	}

}
