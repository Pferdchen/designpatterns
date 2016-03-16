package builder.updateinfoweb;

public class Director {

	private IWebBuild build;

	public Director(IWebBuild build) {
		this.build = build;
	}

	public String build(String accountNO) {
		build.getData(accountNO);
		return build.getUI();
	}

}
