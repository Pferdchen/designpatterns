package visitor.triangle;

public class Test4 {
	public static void main(String[] args) {
		IVisitor v = new ShapeVisitor();
		Triangle t = new Triangle(0, 0, 2, 0, 0, 2);
		Point pt = (Point) t.accept(v, "getCenter");
		System.out.println("Center Point x=" + pt.x + "\ty=" + pt.y);
		Float f = (Float) t.accept(v, "getInnerCircleR");
		System.out.println("Inner Circle r=" + f.floatValue());
	}
}
