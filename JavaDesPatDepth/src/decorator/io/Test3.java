package decorator.io;

import java.io.FileReader;

public class Test3 {

	public static void main(String[] args) throws Exception {
		FileReader in = new FileReader("d:/data.txt");
		MyBufferedReader in2 = new MyBufferedReader(in, 1024);
		String s = "";
		int n = 1;
		while ((s = in2.readToken('-')) != null) {
			System.out.println(n);
			n++;
			System.out.println(s);
		}
		in2.close();
		in.close();
	}

}
