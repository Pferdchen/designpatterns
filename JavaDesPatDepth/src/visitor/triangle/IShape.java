package visitor.triangle;

public interface IShape {
	float getArea();
	float getLength();
	Object accept(IVisitor v, String method);
}
