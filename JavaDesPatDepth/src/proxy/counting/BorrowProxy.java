package proxy.counting;

import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BorrowProxy implements IBorrow {

	private Borrow obj;

	private Map<String, Integer> map;

	public BorrowProxy(Borrow obj) {
		this.obj = obj;
		map = new HashMap<String, Integer>();
	}

	@Override
	public boolean borrow() {
		if (!obj.borrow())
			return false;
		Book book = obj.getBook();
		Integer i = map.get(book.getNO());
		i = (i == null) ? 1 : i + 1;
		map.put(book.getNO(), i);
		return true;
	}

	public void log() throws Exception {
		Set<String> set = map.keySet();
		String key = "";
		String result = "";
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			key = it.next();
			result += key + "\t" + map.get(key) + "\r\n";
		}
		Calendar c = Calendar.getInstance();
		RandomAccessFile fa = new RandomAccessFile("d:/log.txt", "rw");
		fa.seek(fa.length());
		fa.writeBytes(+c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONDAY) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH)
				+ "\r\n");
		fa.writeBytes(result);
		fa.close();
	}

}
