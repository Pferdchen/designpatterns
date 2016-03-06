package factory.factory;

import factory.vehicle.ICar;
import factory.vehicle.MidCar;

public class MidFactory extends AbstractFactory {

	@Override
	public ICar create() {
		return new MidCar();
	}

}
