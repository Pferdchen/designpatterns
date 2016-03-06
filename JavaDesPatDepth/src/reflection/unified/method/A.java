package reflection.unified.method;

import java.lang.reflect.*;

public class A {

	public void func1() {
		System.out.println("This is func1: ");
	}

	public void func2(Integer m) {
		System.out.println("This is func2: " + m);
	}

	public void func3(String s, Integer m) {
		System.out.println("This is func3: " + s + m);
	}

	public static void main(String[] args) throws Exception {
		Class<?> classInfo = Class.forName("reflection.unified.method.A");

		Object obj = classInfo.getConstructor().newInstance();

		// Invoke method without parameter
		Method mt1 = classInfo.getMethod("func1");
		mt1.invoke(obj);

		// Invoke method with 1 parameter
		Method mt2 = classInfo.getMethod("func2", Integer.class);
		mt2.invoke(obj, new Object[] { 10 });

		// Invoke method with 2 parameters
		Method mt3 = classInfo.getMethod("func3", String.class, Integer.class);
		mt3.invoke(obj, new Object[] { "Hello", 2010 });
	}

	boolean process(String className, String funcName, Object[] para) throws Exception {
		Class<?> classType = Class.forName(className);
		Class<?> c[] = new Class[para.length];
		for (int i = 0; i < para.length; i++) {
			c[i] = para[i].getClass();
		}

		Constructor<?> ct = classType.getConstructor();
		Object obj = ct.newInstance();

		Method mt = classType.getMethod(funcName, c);
		mt.invoke(obj, para);
		return true;
	}

}
