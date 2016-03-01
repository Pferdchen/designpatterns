package decorator.copy;

public abstract class Decorator implements ICopy {

	protected ICopy obj;

	public Decorator(ICopy obj) {
		this.obj = obj;
	}

}
