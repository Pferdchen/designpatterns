package observer.pull;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;
import java.util.Vector;

public abstract class AbstractSubject implements ISubject {

	Vector<IObserver> vec = new Vector<IObserver>();

	@Override
	public void register(String strXMLPath) {
		String prefix = "observer";
		String observerClassName = null;
		Properties p = new Properties();
		try {
			FileInputStream in = new FileInputStream(strXMLPath);
			p.loadFromXML(in);
			int n = 1;
			while ((observerClassName = p.getProperty(prefix + n)) != null) {
				Constructor c = Class.forName(observerClassName).getConstructor();
				IObserver obs = (IObserver) Class.forName(observerClassName).newInstance();
				vec.add(obs);
				n++;
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void unregister(IObserver obs) {
		if (vec.contains(obs))
			vec.remove(obs);
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < vec.size(); i++) {
			IObserver obs = vec.get(i);
			obs.refresh(this);
		}
	}

}
