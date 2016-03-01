package command.polygon;

public class AreaCommander implements ICommander {

	private static final String CAL_USAGE = "area";

	PolygonCalc calc;
	Point pt[];

	public AreaCommander(Point[] pt, PolygonCalc calc) {
		this.pt = pt;
		this.calc = calc;
	}

	@Override
	public float calc() {
		return calc.getArea(pt);
	}

	@Override
	public String getCalUsage() {
		return AreaCommander.CAL_USAGE;
	}

}
