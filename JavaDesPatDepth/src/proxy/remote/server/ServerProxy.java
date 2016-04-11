package proxy.remote.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerProxy extends Thread {

	ServerCalc obj;

	public ServerProxy(ServerCalc obj) {
		this.obj = obj;
	}

	public void run() {
		try {
			ServerSocket s = new ServerSocket(4000);
			Socket socket = s.accept();
			while (socket != null) {
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				String method = (String) in.readObject();
				if (method.equals("calc")) {
					String para = (String) in.readObject();
					float f = obj.calc(para);
					out.writeObject(new Float(f));
					out.flush();
				}
			}
//			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
