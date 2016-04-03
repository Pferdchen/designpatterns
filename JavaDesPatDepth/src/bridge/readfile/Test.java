package bridge.readfile;

public class Test {

	public static void main(String[] args) throws Exception {
		AbstractStream in = new URLStream(
				"http://pferdchen.github.io/jekyll_demo/jekyll/update/2015/09/03/welcome-to-jekyll.html");
		TextRead textread = new TextRead(in);
		AbstractThing thing = new URLFile(textread);
		String s = (String) thing.read();
		in.close();
		System.out.println(s);
	}

}
