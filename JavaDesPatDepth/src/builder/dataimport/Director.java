package builder.dataimport;

public class Director {

	AbstractBuild build;

	public Director(AbstractBuild build) {
		this.build = build;
	}

	public void build(String strPath) {
		build.open(strPath);
		while (build.hastNext()) {
			Score s = build.next();
			build.saveToDb(s);
		}
		build.close();
	}

}
