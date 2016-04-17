package proxy.dynamic.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerProxy {

	public static Map<String, Object> map = new HashMap<String, Object>();

	public void registry(String key, Object value) {
		map.put(key, value);
	}

	public void process(int socketNO) throws Exception {
		ServerSocket s = new ServerSocket(socketNO);
		while (true) {
			Socket socket = s.accept();
			if (socket != null) {
				MySocket ms = new MySocket(socket);
				ms.start();
			}
		}
	}
}
