package factory.abstractfactory;

import factory.vehicle.IBus;
import factory.vehicle.ICar;
import factory.vehicle.MidBus;
import factory.vehicle.MidCar;

public class MidFactory extends AbstractFactory {

	@Override
	public ICar createCar() {
		return new MidCar();
	}

	@Override
	public IBus createBus() {
		return new MidBus();
	}

}
