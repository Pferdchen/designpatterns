package bridge.bsshow;

public class SalaryPara implements IPara {

	@Override
	public String[] getTitle() {
		String s[] = { "Employee No", "Employee Name", "January", "February", "March", "April", "May", "June", "July",
				"August", "September", "October", "November", "December" };
		return s;
	}

	@Override
	public String getPreSQL() {
		String s = "select * from salary where emno=";
		return s;
	}

}
