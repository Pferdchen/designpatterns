package framework.stl;

public class AbstractComparator<T> implements IComparator<T> {

	@Override
	public boolean equal(T x, T y) {
		return true;
	}

	@Override
	public boolean less(T x, T y) {
		return true;
	}

}
