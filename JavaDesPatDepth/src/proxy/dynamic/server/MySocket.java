package proxy.dynamic.server;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class MySocket extends Thread {

	Socket socket;

	public MySocket(Socket socket) {
		this.socket = socket;
	}

	public Object invoke(String registname, String methodname, Object para[]) throws Exception {
		Object obj = ServerProxy.map.get(registname);

		Class classType = Class.forName(obj.getClass().getName());
		Class c[] = new Class[para.length];
		for (int i = 0; i < para.length; i++) {
			c[i] = para[i].getClass();
		}

		Method mt = classType.getMethod(methodname, c);
		return mt.invoke(obj, para);
	}

	public void run() {
		while (true) {
			try {
				InputStream ins = socket.getInputStream();
				if (ins == null || ins.available() == 0)
					continue;

				ObjectInputStream in = new ObjectInputStream(ins);
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				String registname = (String) in.readObject();
				String methodname = (String) in.readObject();
				Object[] para = (Object[]) in.readObject();

				Object result = invoke(registname, methodname, para);
				out.writeObject(result);
				out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
