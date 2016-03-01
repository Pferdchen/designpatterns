package visitor.bank;

import java.util.Vector;

public class BankGroup {
	Vector<Bank> v = new Vector<Bank>();

	void add(Bank bank) {
		v.add(bank);
	}

	public void accept(IVisitor<BankGroup> v) {
		v.visit(this);
	}

	public void process(IVisitor<Bank> visit) {
		for (int i = 0; i < v.size(); i++) {
			v.get(i).accept(visit);
		}
	}
}
