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
	
	// �����û�����������ļ�
	private static File file = new File("user.txt");
	private static File file1 = new File("usertime.txt");
	
	static {
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("�����ļ�ʧ��");
		}
	}


	public boolean Login(String username, String password) {
		boolean flag = false;

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine()) != null) {
				if(line.equals("�û���:"+username)) {				
					if(br.readLine().equals("����:"+password)) {		
						flag = true;									
					}
					break;

				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("�û���¼�Ҳ�����Ϣ���ڵ��ļ�");
			// e.printStackTrace();
		} catch (IOException e) {
			System.out.println("�û���¼ʧ��");
			// e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("�û���¼�ͷ���Դʧ��");
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
				if(line.equals("�û���:"+name)) {					
						flag = false;									
					}
				}
		} catch (FileNotFoundException e) {
			System.out.println("�û�ע���Ҳ�����Ϣ���ڵ��ļ�");
			// e.printStackTrace();
		} catch (IOException e) {
			System.out.println("�û�ע��ʧ��");
			// e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("�û�ע���ͷ���Դʧ��");
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
				bw.write("�û���:"+user.getUsername() + "\n����:" + user.getPassword()+ "\n����:" + user.getTime());
				bw.newLine();
				bw.flush();
		} catch (IOException e) {
			System.out.println("�û�ע��ʧ��");
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println("�û�ע���ͷ���Դʧ��");
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
		System.out.println("��������");
		}
		
		
	}
}
