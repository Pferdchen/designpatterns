package framework.process;

import java.util.Scanner;

public class Circle implements IShape {

	float r;

	public Circle() {
	}

	@Override
	public boolean input() {
		System.out.println("Please input r:");
		Scanner s = new Scanner(System.in);
		r = s.nextFloat();
		return true;
	}

	@Override
	public float getArea() {
		float s = (float) Math.PI * r * r;
		return s;
	}

}
