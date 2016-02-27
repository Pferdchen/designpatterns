package decorator.copy;

import java.io.File;

public class DirectCopy extends Decorator {

	public DirectCopy(ICopy copy) {
		super(copy);
	}

	@Override
	public void copy(String oldFolder, String newFolder) throws Exception {
		File file = new File(newFolder);
		if (!file.exists())
			file.mkdirs();
		File oldFile = new File(oldFolder);
		String[] files = oldFile.list();
		File tempFile = null;
		for (int i = 0; i < files.length; i++) {
			if (oldFolder.endsWith(File.separator)) {
				tempFile = new File(oldFolder + files[i]);
			} else {
				tempFile = new File(oldFolder + File.separator + files[i]);
			}

			if (tempFile.isFile()) {
				obj.copy(tempFile.getAbsolutePath(),
						newFolder + File.separator + tempFile.getName());
			}

			if (tempFile.isDirectory()) {
				copy(oldFolder + File.separator + files[i], newFolder + File.separator + files[i]);
			}
		}
	}

}
