package match.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import match.user.User;
import match.user.UserDao;
import match.user.UserDaoImpl;

public class RegistFrame extends JFrame {
	JTextField jtf1;
	JPasswordField jpf1;
	// 构造登录界面
	public RegistFrame() {
		// 初始化登录界面各组件
		initComponents();
		init();
	}

	// 设置登录界面各样式
	private void init() {
		this.setSize(400, 250);
		this.setLocation(346, 250);
		this.setVisible(true);
		this.setTitle("登陆注册界面");
		this.setResizable(false);
	}

	//// 初始化登录界面各组件
	public void initComponents() {

		// 定义各组件
		JPanel jp1, jp2, jp3, jp4;
		JLabel jlb1, jlb2;
		JButton login_jb, regist_jb;


		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();

		jlb1 = new JLabel("用户名 ");
		jlb2 = new JLabel("密     码");

		login_jb = new JButton("登录");
		login_jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				login_jbActionPerformed(evt);
			}
		});
		regist_jb = new JButton("注册");
		regist_jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				regist_jbActionPerformed(evt);
			}
		});

		jtf1 = new JTextField(10);
		jpf1 = new JPasswordField(10);

		// 设置布局管理
		this.setLayout(new GridLayout(4, 1));

		// 在面板中加入各组件
		jp1.add(jlb1);
		jp1.add(jtf1);

		jp2.add(jlb2);
		jp2.add(jpf1);

		jp4.add(login_jb);
		jp4.add(regist_jb);

		// 加入到JFrame
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		
	}
	private void regist_jbActionPerformed(ActionEvent e) {
		String username = this.jtf1.getText().trim();
		String password = String.valueOf(this.jpf1.getPassword()).trim();
		UserDao ud = new UserDaoImpl();
		boolean flag = ud.boolname(username);
		if(flag) {
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			ud.regist(u);
			JOptionPane.showMessageDialog(this, "注册成功");
		}else {
			JOptionPane.showMessageDialog(this, "用户已存在");
		}
	}
	
	private void login_jbActionPerformed(ActionEvent evt) {
		// 获取用户名和密码
		String username = this.jtf1.getText().trim();
		String password = String.valueOf(this.jpf1.getPassword()).trim();//密码文体框获取字符串的非过时方法
		

		// 创建对象调用功能，返回一个boolean值
		UserDao ud = new UserDaoImpl();
		boolean flag = ud.Login(username, password);

		if (flag) {
			JOptionPane.showMessageDialog(this, "恭喜你登录成功");
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
	  		GameFrame ga = new GameFrame(u);
	  		ga.setVisible(true);
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "用户名或者密码有误");
			//this.jtf1.setText("");
			this.jpf1.setText("");
			this.jtf1.requestFocus();
		}
	}

}
