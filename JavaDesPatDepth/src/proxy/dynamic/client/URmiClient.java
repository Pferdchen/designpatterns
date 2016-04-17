package proxy.dynamic.client;

public class URmiClient {

	public static void main(String[] args) throws Exception {
		ICalc obj = new ClientProxy(4000);
		System.out.println(obj.calc("1+5+10"));
		System.out.println(obj.calc("1+5+20"));
	}

}
