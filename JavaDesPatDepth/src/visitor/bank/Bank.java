package visitor.bank;

public abstract class Bank {

	public void accept(IVisitor<Bank> v) {
		v.visit(this);
	}

	public abstract void process(IVisitor<Sheet> visit);
}
