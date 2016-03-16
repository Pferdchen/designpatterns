package builder.dataimport;

import db.connection.DbProc;

public abstract class AbstractBuild {

	public abstract boolean open(String strPath);

	public abstract boolean hastNext();

	public abstract Score next();

	public abstract void close();

	public boolean saveToDb(Score s) {
		String strSQL = "insert into score values('" + s.getStudno() + "', " + "'" + s.getName() + "', " + s.getScore()
				+ ")";
		DbProc dbobj = new DbProc();
		try {
			dbobj.connect();
			dbobj.executeUpate(strSQL);
			dbobj.close();
		} catch (Exception e) {
		}
		return true;
	}

}
