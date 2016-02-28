package framework.polymorphism;

public class Test {

	public static void main(String[] args) {
		IShape2 obj = new Circle2(10.0f);
		int nID = obj.query("getArea");
		Float result = (Float) obj.dispatch(nID, null);
		System.out.println("r 10 circle area:" + result.floatValue());
	}

}
