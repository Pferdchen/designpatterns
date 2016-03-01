package command.polygon;

public class Test2 {

	public static void main(String[] args) {
		CommanderManage manage = new CommanderManage();
		Point pt[] = new Point[3];
		pt[0] = new Point(0, 0);
		pt[1] = new Point(1, 0);
		pt[2] = new Point(0, 1);
		PolygonCalc calc = new PolygonCalc();
		AreaCommander com = new AreaCommander(pt, calc);
		manage.add(com);
		LenCommander com2 = new LenCommander(pt, calc);
		manage.add(com2);
		manage.executeCommand();
	}

}
