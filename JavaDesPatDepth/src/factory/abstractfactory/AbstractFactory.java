package factory.abstractfactory;

import factory.vehicle.IBus;
import factory.vehicle.ICar;

public abstract class AbstractFactory {
	public abstract ICar createCar();
	public abstract IBus createBus();
}
