package factory.simplefactory;

import factory.vehicle.ICar;

public class CarTest {

	/* private is important to avoid creating constructor by client*/
	private CarTest() {
	}

	public static void main(String[] args) {
		ICar obj = CarSimpleFactory.create("toptype");

	}

}
