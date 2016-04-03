package bridge.bsshow;

public class ProductPara implements IPara {

	@Override
	public String[] getTitle() {
		String s[] = { "Product No", "Product Name", "January", "February", "March", "April", "May", "June", "July",
				"August", "September", "October", "November", "December" };
		return s;
	}

	@Override
	public String getPreSQL() {
		String s = "select * from product where prno=";
		return s;
	}

}
