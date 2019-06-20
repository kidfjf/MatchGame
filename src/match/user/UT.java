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
		// target:需要被替换、改写的内容。
		this.target = target;
		// newContent:需要新写入的内容。
		this.newContent = newContent;
		operationFile(file);
	}
 
	public void operationFile(File file) {
 
		try {
			InputStream is = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(is));
 
			String filename = file.getName();
			// tmpfile为缓存文件，代码运行完毕后此文件将重命名为源文件名字。
			File tmpfile = new File(filename + ".txt");
 
			BufferedWriter writer = new BufferedWriter(new FileWriter(tmpfile));
 
			boolean flag = false;
			String str = null;
			while (true) {
				str = reader.readLine();
 
				if (str == null)
					break;
 
				if (str.contains("分数:"+target)) {
					writer.write("分数:"+newContent + "\n");
 
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
