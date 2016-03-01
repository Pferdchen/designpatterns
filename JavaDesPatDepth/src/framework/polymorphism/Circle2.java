package framework.polymorphism;

import java.util.Vector;

public class Circle2 implements IShape2 {

	static Vector<String> vec = new Vector<>();
	static {
		vec.add("getArea");
		vec.add("getPermeter");
	}

	public float r;

	public Circle2(float r) {
		this.r = r;
	}

	@Override
	public Object dispatch(int nID, Object in) {
		Object obj = null;
		switch (nID) {
		case 0:
			obj = getArea(in);
			break;
		case 1:
			obj = getPerimeter(in);
			break;
		}
		return obj;
	}

	Object getArea(Object in) {
		float area = (float) Math.PI * r * r;
		return new Float(area);
	}

	Object getPerimeter(Object in) {
		float len = (float) Math.PI * r * 2.0f;
		return new Float(len);
	}

	@Override
	public int query(String strID) {
		int nID = vec.indexOf(strID);
		return nID;
	}

}
