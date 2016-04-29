package callback.asynchronous;

public class Wolfgang implements CallBack {
	/**
	 * A reference of Linda object. Equivalent to Scene 2
	 */
	private Linda linda;

	/**
	 * Constructor of Wolfang has a reference of Linda
	 * 
	 * @param linda
	 */
	public Wolfgang(Linda linda) {
		this.linda = linda;
	}

	/**
	 * Wolfgang uses this method to ask Linda question.
	 * 
	 * @param question
	 *            the question, which Wolfgang ask for, 1 + 1 = ?
	 */
	public void askQuestion(final String question) {
		// This is a thread and makes asynchronous.
		new Thread(new Runnable() {
			@Override
			public void run() {
				/**
				 * Wolfgang calls the method of Linda, gives CallBack interface
				 * to her. Equivalent to Class A calls the method C of Class B.
				 */
				linda.executeMessage(Wolfgang.this, question);
			}
		}).start();

		// After asking question Wolfgang goes to shopping.
		play();
	}

	public void play() {
		System.out.println("I am going to shopping");
	}

	/**
	 * Linda knows the question and uses this method to tell Wolfgang, namely
	 * Wolfgang's callback function.
	 */
	@Override
	public void solve(String result) {
		System.out.println("Linda tells the answer to Wolfgang--->" + result);
	}

}
