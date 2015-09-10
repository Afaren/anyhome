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
			System.out.println("û���ļ�Ҫ����,�ļ���Ϊ��");
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
					System.out.println("Ŀ���ļ��д���ͬ���ļ���" + tempFile.getName());
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
			System.out.println("��" + counter + "���ļ�������ɣ�" + file.getName());
		}
		System.out.println("�������: ����" + f1Sons.length + "���ļ���������" + counter
				+ "���ļ�");
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
