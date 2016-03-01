package visitor.encrypt;

public class User {
	String user;
	String pwd;
	int type;
	
	public User(String user, String pwd, int type) {
		this.user = user;
		this.pwd = pwd;
		this.type = type;
	}
	
	public User(String user, String pwd) {
		this.user = user;
		this.pwd = pwd;
	}
	
	public void encrypt(IVisitor v) {
		v.visit(this);
	}
}
