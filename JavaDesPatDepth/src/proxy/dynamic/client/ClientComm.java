package proxy.dynamic.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientComm {

	Socket socket;

	public ClientComm(String IP, int socketNO) throws Exception {
		socket = new Socket(IP, socketNO);
	}

	Object invoke(String registname, String methodname, Object[] para) throws Exception {
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		out.writeObject(registname);
		out.writeObject(methodname);
		out.writeObject(para);
		return in.readObject();
	}
}
