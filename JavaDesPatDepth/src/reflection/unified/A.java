package reflection.unified;

import java.lang.reflect.*;

public class A {
	int m;

	public A() {
	}

	public A(int m) {
	}

	@SuppressWarnings("unused")
	private void func1() {
	}

	public void func2() {
	}

	public static void main(String[] args) throws Exception {
		Class<?> classInfo = Class.forName("reflection.unified.A");

		System.out.println("Constructors of class A:");
		Constructor<?> cons[] = classInfo.getConstructors();
		for (int i = 0; i < cons.length; i++)
			System.out.println(cons[i].toString());

		System.out.println();
		System.out.println("Fields of class A");
		Field fields[] = classInfo.getDeclaredFields();
		for (int i = 0; i < fields.length; i++)
			System.out.println(fields[i].toString());

		System.out.println();
		System.out.println("Methods of class A");
		Method methods[] = classInfo.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++)
			System.out.println(methods[i].toString());
	}
}
