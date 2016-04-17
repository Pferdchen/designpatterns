package proxy.jdkdynamic;

public class Test {

	public static void main(String[] args) {
		IRegist email = new FromEmail();
		IRegist post = new FromPost();
		CountInvoke emailInvoke = new CountInvoke(email);
		CountInvoke postInvoke = new CountInvoke(post);
		IRegist emailProxy = (IRegist) GenericProxy.createProxy(email, emailInvoke);
		IRegist postProxy = (IRegist) GenericProxy.createProxy(post, postInvoke);
		emailProxy.regist("email1");
		postProxy.regist("post1");
		System.out.println(emailInvoke.getCount());
		System.out.println(postInvoke.getCount());
	}

}
