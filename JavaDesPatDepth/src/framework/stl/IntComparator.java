package framework.stl;

public class IntComparator implements IComparator<Integer> {

	@Override
	public boolean equal(Integer x, Integer y) {
		return x.intValue() == y.intValue();
	}

	@Override
	public boolean less(Integer x, Integer y) {
		return x.intValue() < y.intValue();
	}

}
