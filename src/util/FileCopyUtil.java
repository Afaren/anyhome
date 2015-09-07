package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyUtil {
	private static File f1, f2;

	public static void Copy(String currentPath, String destiPath) {
		f1 = new File(currentPath);
		f2 = new File(destiPath);
		if (!f2.exists()) {
			f2.mkdir();
		}
		byte[] b = new byte[1024];
		File[] f1Sons = f1.listFiles();
		int c = 0;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		for (File file : f1Sons) {
			try {
				bis = new BufferedInputStream(new FileInputStream(file));
				bos = new BufferedOutputStream(new FileOutputStream(destiPath
						+ "/" + file.getName()));
				while ((c = bis.read(b)) != -1) {
					bos.write(b);
				}
				bos.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			bis.close();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
