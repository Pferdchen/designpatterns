package proxy.virtual;

public class ProxyItem implements IItem {

	private RealItem item;
	boolean bFill;

	public ProxyItem(RealItem item) {
		this.item = item;
	}

	@Override
	public String getAccount() {
		return item.getAccount();
	}

	@Override
	public void setAccount(String account) {
		item.setAccount(account);
	}

	@Override
	public String getName() {
		return item.getName();
	}

	@Override
	public void setName(String name) {
		item.setName(name);
	}

	@Override
	public String getProject() {
		return item.getProject();
	}

	@Override
	public void setProject(String project) {
		item.setProject(project);
	}

	@Override
	public String getContent() {
		return item.getContent();
	}

	@Override
	public String getPlan() {
		return item.getPlan();
	}

	@Override
	public void itemFill() throws Exception {
		if (!bFill)
			item.itemFill();
		bFill = true;
	}

}
