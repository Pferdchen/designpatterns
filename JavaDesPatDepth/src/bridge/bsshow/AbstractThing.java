package bridge.bsshow;

public abstract class AbstractThing {

	private AbstractShow show;
	
	public AbstractThing(AbstractShow show) {
		this.show = show;
	}
	
	public String show(String no) throws Exception {
		return show.show(no);
	}
}
