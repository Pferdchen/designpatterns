package proxy.jdkdynamic;

public class FromEmail implements IRegist {

	@Override
	public void regist(String msg) {
		System.out.println("from Email");
	}

}
