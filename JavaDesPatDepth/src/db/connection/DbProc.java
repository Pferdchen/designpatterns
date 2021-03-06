package db.connection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

/**
 * A property file is needed and contains database connection information. The
 * file is named with "dbconnection.properties" and looks like
 * 
 * DB_URL=jdbc:mysql://localhost:3306/test DB_USER=root DB_PASSWORD=123456
 * DB_DRIVER=com.mysql.jdbc.Driver
 * 
 * @author Yan Gao
 *
 */
public class DbProc {
	private String strDriver;
	private String strDb;
	private String strUser;
	private String strPwd;
	private Connection conn;

	public Connection connect() throws Exception {
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("dbconnection.properties");
		Properties p = new Properties();
		p.load(inputStream);

		strDriver = p.getProperty("DB_DRIVER");
		strDb = p.getProperty("DB_URL");
		strUser = p.getProperty("DB_USER");
		strPwd = p.getProperty("DB_PASSWORD");

		Class.forName(strDriver);
		conn = DriverManager.getConnection(strDb, strUser, strPwd);
		return conn;
	}

	public int executeUpate(String strSQL) throws Exception {
		Statement stm = conn.createStatement();
		int n = stm.executeUpdate(strSQL);
		stm.close();
		return n;
	}

	public List<Vector<String>> executeQuery(String strSQL) throws Exception {
		List<Vector<String>> l = new Vector<Vector<String>>();
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(strSQL);
		ResultSetMetaData rsmd = rst.getMetaData();
		while (rst.next()) {
			Vector<String> unit = new Vector<String>();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				unit.add(rst.getString(i));
			}
			l.add(unit);
		}
		return l;
	}

	public void close() throws Exception {
		conn.close();
	}
}
