package command.polygon;

public class Test {

	public static void main(String[] args) {
		CommanderManage manage = new CommanderManage();
		PolygonCalc calc = new PolygonCalc();

		Point pt[] = new Point[3];
		pt[0] = new Point(0, 0);
		pt[1] = new Point(1, 0);
		pt[2] = new Point(0, 1);
		AreaCommander com = new AreaCommander(pt, calc);
		manage.add(com);

		pt = new Point[3];
		pt[0] = new Point(0, 0);
		pt[1] = new Point(2, 0);
		pt[2] = new Point(0, 2);
		AreaCommander com2 = new AreaCommander(pt, calc);
		manage.add(com2);

		manage.executeCommand();
	}

}
