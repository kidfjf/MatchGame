package match.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import match.user.*;

public class UserDaoImpl implements UserDao {
	
	// 保存用户名及密码的文件
	private static File file = new File("user.txt");
	private static File file1 = new File("usertime.txt");
	
	static {
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("创建文件失败");
		}
	}


	public boolean Login(String username, String password) {
		boolean flag = false;

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine()) != null) {
				if(line.equals("用户名:"+username)) {				
					if(br.readLine().equals("密码:"+password)) {		
						flag = true;									
					}
					break;

				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("用户登录找不到信息所在的文件");
			// e.printStackTrace();
		} catch (IOException e) {
			System.out.println("用户登录失败");
			// e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("用户登录释放资源失败");
					// e.printStackTrace();
				}
			}
		}

		return flag;
	}

	public boolean boolname(String name) {
		boolean flag = true;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine()) != null) {
				if(line.equals("用户名:"+name)) {					
						flag = false;									
					}
				}
		} catch (FileNotFoundException e) {
			System.out.println("用户注册找不到信息所在的文件");
			// e.printStackTrace();
		} catch (IOException e) {
			System.out.println("用户注册失败");
			// e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("用户注册释放资源失败");
					// e.printStackTrace();
				}
			}
		}
		return flag;	
	}
	public void regist(User user) {
		BufferedWriter bw = null;
		try {
				bw = new BufferedWriter(new FileWriter(file, true));
				bw.write("用户名:"+user.getUsername() + "\n密码:" + user.getPassword()+ "\n分数:" + user.getTime());
				bw.newLine();
				bw.flush();
		} catch (IOException e) {
			System.out.println("用户注册失败");
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println("用户注册释放资源失败");
				}
			}
		}
	}
	public void usertime(User user) {
		String line = null;
		String str="";
		try {
			BufferedReader in = new BufferedReader(new FileReader("user.txt"));
			while((line = in.readLine())!=null)
			{
			str+=line;
			}
			if(str.contains(Integer.toString(user.getTime()))) {
				int i=str.indexOf("user.getTime()");
				} 
		}
		catch (IOException e) {
		System.out.println("发生错误");
		}
		
		
	}
}
