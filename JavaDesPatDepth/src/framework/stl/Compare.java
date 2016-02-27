package framework.stl;

import java.util.Arrays;

public class Compare {

	public static void main(String[] args) {
		Integer[] arr = { 6, 5, 4, 3, 2, 1 };
		System.out.println("Initial array: " + Arrays.toString(arr));
		IComparator<Integer> cmp = new IntComparator();
		Algorithm<Integer> algo = new Algorithm<Integer>(cmp);
		// algo.partial_sort(arr, 6);
		// System.out.println("Partial sort array: " + Arrays.toString(arr));

		Integer i = algo.median(43, 3, 100);
		System.out.println("Median: " + i.intValue());

		algo.push_heap(arr, 2, 5, 9);
		System.out.println("push_heap: " + Arrays.toString(arr));
	}

}
