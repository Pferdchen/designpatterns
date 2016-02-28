package framework.process;

import java.util.Scanner;

public class Rect implements IShape {

	float width, height;

	@Override
	public boolean input() {
		System.out.println("Please input width and height:");
		Scanner s = new Scanner(System.in);
		width = s.nextFloat();
		height = s.nextFloat();
		return true;
	}

	@Override
	public float getArea() {
		float s = width * height;
		return s;
	}

}
