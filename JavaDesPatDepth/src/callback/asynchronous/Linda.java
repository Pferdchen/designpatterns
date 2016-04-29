package callback.asynchronous;

public class Linda {
	/**
	 * Equivalent to Scene 3. Class B has function f() with parameter callBack.
	 * 
	 * @param callBack
	 * @param question
	 *            Wolfgang's question
	 */
	public void executeMessage(CallBack callBack, String question) {
		System.out.println("Wolfgang's question--->" + question);

		// Simulate Linda doing her own thing takes a long time
		for (int i = 0; i < 10000; i++) {

		}

		/*
		 * Linda after finishing her own thing thinks the answer is 2
		 */
		String result = "Result is 2";

		/*
		 * So she calls Wolfgang to tell him, calling his method.
		 */
		callBack.solve(result);
	}

}
