package factory.readfile;

import java.io.File;
import java.io.FileInputStream;

public class TextRead implements IRead<String> {

	@Override
	public String read(String... in) {
		String result = null;
		try {
			File file = new File(in[0]);
			long len = file.length();
			FileInputStream input = new FileInputStream(in[0]);
			byte buf[] = new byte[(int) len];
			input.read(buf);
			result = new String(buf, in[1]);
			input.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
