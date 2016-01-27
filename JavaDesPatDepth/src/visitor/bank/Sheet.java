package visitor.bank;

public abstract class Sheet {
	String account;
	String name;
	float money;
	String startDate;
	int range;

	public Sheet(String account, String name, float money, String startDate,
			int range) {
		this.account = account;
		this.name = name;
		this.money = money;
		this.startDate = startDate;
		this.range = range;
	}

	public void accept(IVisitor<Sheet> v) {
		v.visit(this);
	}
}
