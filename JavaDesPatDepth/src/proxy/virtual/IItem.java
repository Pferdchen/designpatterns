package proxy.virtual;

public interface IItem {
	String getAccount();
	void setAccount(String account);
	String getName();
	void setName(String name);
	String getProject();
	void setProject(String project);
	String getContent();
	String getPlan();
	void itemFill() throws Exception;
}
