package proxy.virtual;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import db.connection.DbProc;

public class RealItem implements IItem {

	private String account;
	private String name;
	private String project;
	private String content;
	private String plan;

	@Override
	public String getAccount() {
		return account;
	}

	@Override
	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getProject() {
		return project;
	}

	@Override
	public void setProject(String project) {
		this.project = project;
	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public String getPlan() {
		return plan;
	}

	@Override
	public void itemFill() throws Exception {
		String strSQL = "select content, plan from project where account='" + account + "'";
		
		DbProc dbobj = new DbProc();
		Connection conn = dbobj.connect();
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(strSQL);
		rst.next();
		content = rst.getString("content");
		plan = rst.getString("plan");
		rst.close();
		stm.close();
		conn.close();
	}

}
