package framework.stl;

public interface IComparator<T> {
	boolean equal(T x, T y);

	boolean less(T x, T y);
}
