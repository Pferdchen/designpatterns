package observer.temperature;

import java.util.Observable;
import java.util.Observer;

import db.connection.DbProc;

public class DataObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		Subject subject = (Subject) o;
		String strSQL = "insert into normal values(" + subject.getData() + ", now()";
		DbProc dbobj = new DbProc();
		try {
			dbobj.connect();
			dbobj.executeUpate(strSQL);
			dbobj.close();
		} catch (Exception e) {
		}
	}

}
