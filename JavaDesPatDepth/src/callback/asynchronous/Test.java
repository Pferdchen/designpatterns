package callback.asynchronous;

public class Test {

	public static void main(String[] args) {
		/**
		 * new a Linda
		 */
		Linda linda = new Linda();

		/**
		 * new a Wolfgang
		 */
		Wolfgang wolfgang = new Wolfgang(linda);

		/**
		 * Wolfgang asks Linda question
		 */
		wolfgang.askQuestion("1 + 1 = ?");
	}

}
