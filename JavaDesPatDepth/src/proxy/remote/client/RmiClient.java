package proxy.remote.client;

import java.rmi.Naming;

public class RmiClient {

	public static void main(String[] args) {
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new SecurityManager());
		try {
			ICalc obj = (ICalc) Naming.lookup("rmi://localhost:1099/calc");
			System.out.println(obj.calc("1+2+3"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
