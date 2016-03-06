package factory.abstractfactory;

import factory.vehicle.IBus;
import factory.vehicle.ICar;
import factory.vehicle.TopCar;
import factory.vehicle.UpBus;

public class TopFactory extends AbstractFactory {

	@Override
	public ICar createCar() {
		return new TopCar();
	}

	@Override
	public IBus createBus() {
		return new UpBus();
	}

}
