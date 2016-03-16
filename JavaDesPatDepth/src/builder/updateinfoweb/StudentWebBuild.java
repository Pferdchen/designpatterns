package builder.updateinfoweb;

import java.util.List;
import java.util.Vector;

import db.connection.DbProc;

public class StudentWebBuild implements IWebBuild {

	private String name, age, major, depart;

	@Override
	public void getData(String user) {
		String strSQL = "select name, age, major, depart from student where user='" + user + "'";
		DbProc dbobj = new DbProc();
		try {
			dbobj.connect();
			List l = (List) dbobj.executeQuery(strSQL);
			dbobj.close();
			Vector v = (Vector) l.get(0);
			name = (String) v.get(0);
			age = (String) v.get(1);
			major = (String) v.get(2);
			depart = (String) v.get(3);
		} catch (Exception e) {
		}
	}

	@Override
	public String getUI() {
		String s = "Name:<input type='text' id='name' value='" + name + "'/><br>"
				+ "Age:<input type='text' id='age' value='" + age + "'/><br>"
				+ "Major:<input type='text' id='major' value='" + major + "'/><br>"
				+ "Department:<input type='text' id='depart' value='" + depart + "'/><br>"
				+ "<input type='button' id='myupdate' value='Update'/>";
		return s;
	}

}
