package state.memory;

public class HighState implements IState {

	private int times;

	@Override
	public String getStateInfo() {
		return "Sufficient";
	}

	@Override
	public int getStateInterval() {
		return times++;
	}

}
