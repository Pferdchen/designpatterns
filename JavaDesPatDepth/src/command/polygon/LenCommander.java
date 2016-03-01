package command.polygon;

public class LenCommander implements ICommander {

	private static final String CAL_USAGE = "length";

	PolygonCalc calc;
	Point pt[];

	public LenCommander(Point[] pt, PolygonCalc calc) {
		this.pt = pt;
		this.calc = calc;
	}

	@Override
	public float calc() {
		return calc.getLength(pt);
	}

	@Override
	public String getCalUsage() {
		return LenCommander.CAL_USAGE;
	}

}
