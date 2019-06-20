package match.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UT {
	 
	private static File file = new File("user.txt");
	private final String target;
	private final String newContent;
 
	public UT(String target, String newContent) {
		// target:��Ҫ���滻����д�����ݡ�
		this.target = target;
		// newContent:��Ҫ��д������ݡ�
		this.newContent = newContent;
		operationFile(file);
	}
 
	public void operationFile(File file) {
 
		try {
			InputStream is = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(is));
 
			String filename = file.getName();
			// tmpfileΪ�����ļ�������������Ϻ���ļ���������ΪԴ�ļ����֡�
			File tmpfile = new File(filename + ".txt");
 
			BufferedWriter writer = new BufferedWriter(new FileWriter(tmpfile));
 
			boolean flag = false;
			String str = null;
			while (true) {
				str = reader.readLine();
 
				if (str == null)
					break;
 
				if (str.contains("����:"+target)) {
					writer.write("����:"+newContent + "\n");
 
					flag = true;
				} else
					writer.write(str + "\n");
			}
 
			is.close();
 
			writer.flush();
			writer.close();
 
			if (flag) {
				file.delete();
				tmpfile.renameTo(new File(file.getAbsolutePath()));
			} else
				tmpfile.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
