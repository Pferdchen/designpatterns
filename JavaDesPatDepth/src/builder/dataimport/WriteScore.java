package builder.dataimport;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteScore {

	public static void main(String[] args) {
		Score[] scores = new Score[3];
		scores[0] = new Score("0011000001", "zhang3", 89);
		scores[1] = new Score("0011000011", "li4", 69);
		scores[2] = new Score("0011000020", "feng1", 44);
		byte[] name = new byte[10];
		byte[] mid = null;
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("d:/score.dat");
			DataOutputStream dos = new DataOutputStream(fos);
			for (int i = 0; i < scores.length; i++) {
				for (int j = 0; j < name.length; j++) {
					name[j] = 0;
				}
				mid = scores[i].getName().getBytes();// name need be adjust to
														// 10 byte
				for (int k = 0; k < mid.length; k++)
					name[k] = mid[k];
				dos.write(scores[i].getStudno().getBytes());// studno has 10
															// byte
				dos.write(name);
				dos.writeInt(scores[i].getScore());
			}
			dos.close();
			fos.close();
			//
			FileInputStream fis = new FileInputStream("d:/score.dat");
			DataInputStream dis = new DataInputStream(fis);
			for (int i = 0; i < scores.length; i++) {
				byte[] buf1 = new byte[10];
				int len = dis.read(buf1);
				System.out.println(new String(buf1, 0, len, "GBK"));// print
																	// studno

				byte[] buf2 = new byte[10];
				len = dis.read(buf2);
				System.out.println(new String(buf2, 0, len, "GBK"));// print
																	// name

				System.out.println(dis.readInt());// print score
			}
			dis.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
