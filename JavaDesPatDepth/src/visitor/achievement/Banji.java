package visitor.achievement;

import java.util.Vector;

import javax.swing.JPanel;

public class Banji {
	Vector<Student> v = new Vector<Student>();
	
	public Vector<Student> getV() {
		return v;
	}
	
	void add(Student s) {
		v.add(s);
	}
	
	void statistics(IVisitor v, JPanel panel) {
		v.visit(this, panel);
	}
}
