package visitor.bank;

import java.util.Vector;

public class ABCBank extends Bank {
	Vector<ABCSheet> v = new Vector<ABCSheet>();

	void add(ABCSheet s) {
		v.add(s);
	}

	@Override
	public void process(IVisitor<Sheet> visit) {
		for (int i = 0; i < v.size(); i++) {
			v.get(i).accept(visit);
		}
	}
}
