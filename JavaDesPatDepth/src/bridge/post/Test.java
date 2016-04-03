package bridge.post;

public class Test {

	public static void main(String[] args) {
		IPost p = new SimplePost();
		Letter letter = new Letter(p);
		letter.post();
	}

}
