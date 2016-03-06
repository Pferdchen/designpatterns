package factory.readfile;

public abstract class AbstractFactory {
	public abstract IRead<?> create();
	
	static AbstractFactory create(String className) {
		AbstractFactory factory = null;
		try {
			Class<?> c = Class.forName(className);
			factory = (AbstractFactory) c.newInstance();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return factory;
	}
}
