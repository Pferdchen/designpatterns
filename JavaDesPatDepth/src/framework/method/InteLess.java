package framework.method;

public class InteLess implements ILess<Integer> {

	@Override
	public boolean less(Integer x, Integer y) {
		return x < y;
	}

}
