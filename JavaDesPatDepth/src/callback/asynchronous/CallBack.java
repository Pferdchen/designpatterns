package callback.asynchronous;

/**
 * This is CallBack interface.
 * 
 * Scene 1: Class A implements interface CallBack and a callback function. 
 * Scene 2: Class A contains a reference of Class B. 
 * Scene 3: Class B has Function C with parameter callback. C is named register function.
 * Object a of Class A calls the register function f(CallBack callback) of Class B. 
 * Object b can call the callback function of A inside Function C.
 * 
 * @author Yan.Gao
 *
 */
public interface CallBack {
	/**
	 * When Linda knows the answer, she will call the function to tell Wolfgang,
	 * namely callback function.
	 * 
	 * @param result
	 *            the answer
	 */
	public void solve(String result);
}

/*
run() is also a callback function.
Runnable is like CallBack interface.
Thread is like Class B.
start() is like Function C.
Because the implementation of Runnable is inside the Thread object, 
so start() can call run() directly without any callback parameter.

	new Thread(new Runnable() {
		@Override
		public void run() {
			//Do something
		}
	}).start();

*/