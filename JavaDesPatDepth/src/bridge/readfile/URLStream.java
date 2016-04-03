package bridge.readfile;

import java.net.HttpURLConnection;
import java.net.URL;

public class URLStream extends AbstractStream {

	public URLStream(String strFile) throws Exception {
		URL url = new URL(strFile);
		in = url.openStream();
		HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
		size = urlcon.getContentLength();
	}
	
}
