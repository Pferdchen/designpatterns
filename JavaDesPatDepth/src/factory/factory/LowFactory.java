package factory.factory;

import factory.vehicle.ICar;
import factory.vehicle.LowCar;

public class LowFactory extends AbstractFactory {

	@Override
	public ICar create() {
		return new LowCar();
	}

}
