package reflection.unified;

import java.io.FileInputStream;
import java.util.Properties;

import framework.process.*;

public class Test {
	
	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
//		p.load(new FileInputStream("shape.properties"));
		p.loadFromXML(new FileInputStream("shape.xml"));
		String cname = p.getProperty("shape");
		IShape shape = null;
		shape = (IShape) Class.forName(cname).getConstructor().newInstance();
		ShapeProc obj = new ShapeProc(shape);
		float value = obj.process();
		System.out.println("Area is: " + value);
	}

}
