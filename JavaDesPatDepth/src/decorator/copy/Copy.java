package decorator.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Copy implements ICopy {

	@Override
	public void copy(String srcFile, String destFile) throws Exception {
		File file = new File(srcFile);
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte buf[] = new byte[(int) file.length()];
		in.read(buf);
		out.write(buf);
		in.close();
		out.close();
	}

}
