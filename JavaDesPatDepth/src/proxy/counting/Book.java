package proxy.counting;

public class Book {

	private String NO;

	private String name;

	public Book(String NO, String name) {
		this.NO = NO;
		this.name = name;
	}

	public String getNO() {
		return NO;
	}

	public void setNO(String nO) {
		NO = nO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
