package observer.temperature;

import java.io.FileInputStream;
import java.util.Observer;
import java.util.Properties;

public class Test {

	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("temperature.xml");
		Properties p = new Properties();
		p.loadFromXML(in);
		int range = Integer.parseInt(p.getProperty("range"));
		String reflectClassName = p.getProperty("reflect");
		int limit = Integer.parseInt(p.getProperty("limit"));
		int nums = Integer.parseInt(p.getProperty("nums"));
		String address = p.getProperty("address");
		Factor factor = new Factor(limit, nums, address);
		in.close();

		Subject s = new Subject();
		Observer obj = new DataObserver();
		Observer obj2 = new AbnormalObserver();
		s.addObserver(obj);
		s.setFactor(factor);

		ISimuData<Integer> sdobj = (ISimuData<Integer>) Class.forName(reflectClassName).newInstance();
		sdobj.open();
		while (sdobj.hasNext()) {
			int value = sdobj.next();
			s.setData(value);
			try {
				Thread.sleep(range * 1000);
			} catch (Exception e) {
			}
		}
		sdobj.close();
	}

}
