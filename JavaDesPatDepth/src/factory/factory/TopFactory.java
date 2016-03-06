package factory.factory;

import factory.vehicle.ICar;
import factory.vehicle.TopCar;

public class TopFactory extends AbstractFactory {

	@Override
	public ICar create() {
		return new TopCar();
	}

}
