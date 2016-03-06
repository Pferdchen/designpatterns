package factory.abstractfactory;

import factory.vehicle.DnBus;
import factory.vehicle.IBus;
import factory.vehicle.ICar;
import factory.vehicle.LowCar;

public class LowFactory extends AbstractFactory {

	@Override
	public ICar createCar() {
		return new LowCar();
	}

	@Override
	public IBus createBus() {
		return new DnBus();
	}

}
