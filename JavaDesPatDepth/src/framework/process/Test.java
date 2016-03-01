package framework.process;

public class Test {

	public static void main(String[] args) {
		IShape shape = new Circle();
		ShapeProc obj = new ShapeProc(shape);
		float value = obj.process();
		System.out.println("Circle area:" + value);

		IShape shape2 = new Rect();
		ShapeProc obj2 = new ShapeProc(shape2);
		float value2 = obj2.process();
		System.out.println("Rectangle area:" + value2);
	}

}
