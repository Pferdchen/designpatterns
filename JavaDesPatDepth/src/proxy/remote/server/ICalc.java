package proxy.remote.server;

import java.rmi.Remote;

public interface ICalc extends Remote {
	float calc(String s) throws Exception;
}
