package proxy.remote.server;

import java.rmi.Naming;

public class RmiServer {

	public static void main(String[] args) {
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new SecurityManager());
		try {
			ServerCalc obj = new ServerCalc();
			Naming.rebind("calc", obj);
			System.out.println("server bind success!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
