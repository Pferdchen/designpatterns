package proxy.dynamic.server;

public class URmiServer {

	public static void main(String[] args) throws Exception {
		ServerCalc obj = new ServerCalc();
		ServerProxy spobj = new ServerProxy();
		spobj.registry("calc", obj);
		spobj.process(4000);// ???
	}

}
