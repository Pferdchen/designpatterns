package factory.readfile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageRead implements IRead<ImageInfo> {

	@Override
	public ImageInfo read(String... in) {
		BufferedImage bi = null;
		File f = new File(in[0]);
		try {
			bi = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int width = bi.getWidth();
		int height = bi.getHeight();
		int rgb[] = new int[width * height];
		// put image data into result buffer
		bi.getRGB(0, 0, width, height, rgb, width, height);
		ImageInfo obj = new ImageInfo();
		obj.setWidth(width);
		obj.setHeight(height);
		obj.setRGB(rgb);
		return obj;
	}

}
