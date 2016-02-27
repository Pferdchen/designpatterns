package visitor.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptVisitor implements IVisitor {

	private String encode(String str) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte buf[] = md.digest();
			result = byteToString(buf);
		} catch (NoSuchAlgorithmException e) {
		}
		return result;
	}

	private String byteToString(byte[] aa) {
		String hash = "";
		for (int i = 0; i < aa.length; i++) {
			int temp;
			temp = aa[i] < 0 ? aa[i] + 256 : aa[i];
			if (temp < 16)
				hash += "0";
			hash += Integer.toString(temp, 16);
		}
		hash = hash.toUpperCase();
		return hash;
	}

	@Override
	public void visit(User u) {
		u.user = encode(u.user);
		u.pwd = encode(u.pwd);

	}

}
