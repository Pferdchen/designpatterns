package proxy.remote.server;

public class ServerTest {

	public static void main(String[] args) throws Exception {
		ServerCalc obj = new ServerCalc();
		ServerProxy spobj = new ServerProxy(obj);
		spobj.start();
	}

}
