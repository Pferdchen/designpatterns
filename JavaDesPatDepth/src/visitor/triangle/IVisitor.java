package visitor.triangle;

public interface IVisitor {
	Object visit(Triangle t, String method);
}
