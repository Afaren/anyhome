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

		byte[] b = new byte[100];
		File[] f1Sons = f1.listFiles();
		File[] f2Sons = f2.listFiles();
		if (0 == f1Sons.length) {
			System.out.println("没有文件要复制,文件夹为空");
			return;
		}
		int c;
		int counter = 0;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		for (File file : f1Sons) {
			counter++;
			File tempFile = new File(destiPath + "/" + file.getName());
			try {
				if (tempFile.exists()) {
					System.out.println("目标文件夹存在同名文件：" + tempFile.getName());
					counter--;
					continue;
				}
				bis = new BufferedInputStream(new FileInputStream(file));
				bos = new BufferedOutputStream(new FileOutputStream(tempFile));
				while ((c = bis.read(b)) != -1) {
					bos.write(b);
				}
				bos.flush();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("第" + counter + "个文件复制完成：" + file.getName());
		}
		System.out.println("复制完成: 共有" + f1Sons.length + "个文件，复制了" + counter
				+ "个文件");
		try {
			if (bis != null) {
				bis.close();
				bos.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
