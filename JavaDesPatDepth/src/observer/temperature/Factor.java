package observer.temperature;

public class Factor {

	private int limit;
	private int times;
	private String address;

	public Factor(int limit, int nums, String address) {
		this.limit = limit;
		this.times = nums;
		this.address = address;
	}

	public int getLimit() {
		return limit;
	}

	public int getTimes() {
		return times;
	}

	public String getAddress() {
		return address;
	}

}
