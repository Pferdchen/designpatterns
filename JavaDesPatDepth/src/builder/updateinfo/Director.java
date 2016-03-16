package builder.updateinfo;

import javax.swing.JPanel;

public class Director {

	private UIBuilder build;

	public Director(UIBuilder builder) {
		this.build = builder;
	}

	public JPanel build(String user) {
		build.addUI();
		build.registerMsg();
		build.initialData(user);
		return build.getPanel();
	}
}
