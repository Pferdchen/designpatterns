package factory.readfile;

public class ImageFactory extends AbstractFactory {

	@Override
	public IRead<?> create() {
		return new ImageRead();
	}

}
