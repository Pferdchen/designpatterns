package visitor.bank;

public class Test {

	public static void main(String[] args) {
		ICBCSheet s = new ICBCSheet("1000", "zhang", 100, "2012-1-1", 3);

		IVisitor<Sheet> v = new SheetVisitor();
		s.accept(v);// println "ICBCSheet process"

		ICBCBank manage = new ICBCBank();
		manage.add(s);
		manage.process(v);// println "ICBCSheet process"
	}

}
