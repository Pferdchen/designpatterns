package factory.factory;

import factory.vehicle.ICar;

public class CarTest {

	public static void main(String[] args) {
		AbstractFactory obj = new TopFactory();
		ICar car = obj.create();
	}

}
