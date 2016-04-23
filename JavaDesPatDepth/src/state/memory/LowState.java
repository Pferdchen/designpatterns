package state.memory;

public class LowState implements IState {

	private int times;

	@Override
	public String getStateInfo() {
		return "Normal";
	}

	@Override
	public int getStateInterval() {
		return times++;
	}

}
