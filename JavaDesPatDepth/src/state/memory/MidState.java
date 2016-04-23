package state.memory;

public class MidState implements IState {

	private int times;

	@Override
	public String getStateInfo() {
		return "Good";
	}

	@Override
	public int getStateInterval() {
		return times++;
	}

}
