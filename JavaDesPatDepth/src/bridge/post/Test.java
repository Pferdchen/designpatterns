package bridge.post;

public class Test {

	public static void main(String[] args) throws Exception {
		IPost p = new SimplePost();
		Letter letter = new Letter(p);
		letter.post();
		
		//use reflection
		System.out.println("use reflection");
		ThingManage obj = new ThingManage();
		AbstractThing thing = obj.createThing("bridge.post.Letter");
		thing.createPost("bridge.post.SimplePost");
		thing.post();
	}

}
