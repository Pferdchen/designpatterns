package proxy.remote.client;

import java.rmi.Remote;

public interface ICalc extends Remote {
	float calc(String s) throws Exception;
}
