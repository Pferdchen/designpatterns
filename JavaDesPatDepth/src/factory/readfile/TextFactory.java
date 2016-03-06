package factory.readfile;

public class TextFactory extends AbstractFactory {

	@Override
	public IRead<?> create() {
		return new TextRead();
	}

}
