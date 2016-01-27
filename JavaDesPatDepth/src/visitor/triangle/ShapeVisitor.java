package visitor.triangle;

import java.lang.reflect.Method;

public class ShapeVisitor implements IVisitor {
	public Object getCenter(Triangle t) {
		Point pt = new Point();
		pt.x = (t.x1 + t.x2 + t.x3) / 3;
		pt.y = (t.y1 + t.y2 + t.y3) / 3;
		return pt;
	}

	public Float getInnerCircleR(Triangle t) {
		float area = t.getArea();
		float len = t.getLength();
		return new Float(2.0f * area / len);
	}

	@Override
	public Object visit(Triangle t, String method) {
		Object result = null;
		try {
			Class<? extends ShapeVisitor> classinfo = this.getClass();
			Method mt = classinfo.getMethod(method, Triangle.class);
			result = mt.invoke(this, new Object[] { t });// getCenter() or getInnerCircleR()
		} catch (Exception e) {
		}
		return result;// return Point or Float object
	}

}
