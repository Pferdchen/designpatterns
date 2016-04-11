package proxy.remote.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerCalc extends UnicastRemoteObject implements ICalc {

	protected ServerCalc() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public float calc(String s) throws Exception {
		s += "+0";
		float result = 0;
		float value = 0;
		char opcur = '+';
		char opnext;
		int start = 0;
		if (s.charAt(0) == '-') {
			opcur = '-';
			start = 1;
		}

		for (int i = start; i < s.length(); i++) {
			if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				opnext = s.charAt(i);
				value = Float.parseFloat(s.substring(start, i));
				switch (opcur) {
				case '+':
					result += value;
					break;
				case '-':
					result -= value;
					break;
				}
				start = i + 1;
				opcur = opnext;
				i = start;
			}
		}
		return result;
	}

}
