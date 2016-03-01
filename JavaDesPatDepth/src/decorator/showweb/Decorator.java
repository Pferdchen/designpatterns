package decorator.showweb;

import javax.servlet.http.HttpServletRequest;

public class Decorator implements IShow {

	protected IShow obj;
	
	public Decorator(IShow obj) {
		this.obj = obj;
	}

	@Override
	public int getPage() {
		return obj.getPage();
	}

	@Override
	public int getTotal() {
		return obj.getTotal();
	}

	@Override
	public String show(HttpServletRequest req) throws Exception {
		return obj.show(req);
	}

}
