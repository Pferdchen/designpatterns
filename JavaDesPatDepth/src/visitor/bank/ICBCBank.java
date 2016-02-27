package visitor.bank;

import java.util.Vector;

public class ICBCBank extends Bank {
	Vector<ICBCSheet> v = new Vector<ICBCSheet>();

	void add(ICBCSheet s) {
		v.add(s);
	}

	@Override
	public void process(IVisitor<Sheet> visit) {
		for (int i = 0; i < v.size(); i++) {
			v.get(i).accept(visit);
		}
	}
}
