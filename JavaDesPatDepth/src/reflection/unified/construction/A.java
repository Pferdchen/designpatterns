package reflection.unified.construction;

import java.lang.reflect.*;

public class A {

	public A() {
		System.out.println("This is A:");
	}

	public A(Integer m) {
		System.out.println("This is " + m);
	}

	public A(String s, Integer m) {/* If m is int type, would be an exception */
		System.out.println(s + ":" + m);
	}

	public static void main(String[] args) throws Exception {
		Class<?> classInfo = Class.forName("reflection.unified.construction.A");

		System.out.println("Construction approch 1");
		Constructor<?> cons[] = classInfo.getConstructors();
		// Construction without parameter
		cons[2].newInstance();
		// Construction with 1 parameter
		cons[1].newInstance(new Object[] { 10 });
		// Construction with 2 parameters
		cons[0].newInstance(new Object[] { "Hello", 2010 });

		System.out.println("\n\n\n");
		System.out.println("Construction approch 2");
		// Construction without parameter
		Constructor<?> c = classInfo.getConstructor();
		c.newInstance();
		// Construction with 1 parameter
		c = classInfo.getConstructor(new Class[] { Integer.class });
		c.newInstance(new Object[] { 10 });
		// Construction with 2 parameters
		c = classInfo.getConstructor(new Class[] { String.class, Integer.class });
		c.newInstance(new Object[] { "Hello", 2010 });
	}

}
