package bridge.bsshow;

public abstract class AbstractShow {

	public IPara para;

	public void setPara(IPara para) {
		this.para = para;
	}

	abstract public String show(String no) throws Exception;

}
