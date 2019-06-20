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
	// �����¼����
	public RegistFrame() {
		// ��ʼ����¼��������
		initComponents();
		init();
	}

	// ���õ�¼�������ʽ
	private void init() {
		this.setSize(400, 250);
		this.setLocation(346, 250);
		this.setVisible(true);
		this.setTitle("��½ע�����");
		this.setResizable(false);
	}

	//// ��ʼ����¼��������
	public void initComponents() {

		// ��������
		JPanel jp1, jp2, jp3, jp4;
		JLabel jlb1, jlb2;
		JButton login_jb, regist_jb;


		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();

		jlb1 = new JLabel("�û��� ");
		jlb2 = new JLabel("��     ��");

		login_jb = new JButton("��¼");
		login_jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				login_jbActionPerformed(evt);
			}
		});
		regist_jb = new JButton("ע��");
		regist_jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				regist_jbActionPerformed(evt);
			}
		});

		jtf1 = new JTextField(10);
		jpf1 = new JPasswordField(10);

		// ���ò��ֹ���
		this.setLayout(new GridLayout(4, 1));

		// ������м�������
		jp1.add(jlb1);
		jp1.add(jtf1);

		jp2.add(jlb2);
		jp2.add(jpf1);

		jp4.add(login_jb);
		jp4.add(regist_jb);

		// ���뵽JFrame
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
			JOptionPane.showMessageDialog(this, "ע��ɹ�");
		}else {
			JOptionPane.showMessageDialog(this, "�û��Ѵ���");
		}
	}
	
	private void login_jbActionPerformed(ActionEvent evt) {
		// ��ȡ�û���������
		String username = this.jtf1.getText().trim();
		String password = String.valueOf(this.jpf1.getPassword()).trim();//����������ȡ�ַ����ķǹ�ʱ����
		

		// ����������ù��ܣ�����һ��booleanֵ
		UserDao ud = new UserDaoImpl();
		boolean flag = ud.Login(username, password);

		if (flag) {
			JOptionPane.showMessageDialog(this, "��ϲ���¼�ɹ�");
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
	  		GameFrame ga = new GameFrame(u);
	  		ga.setVisible(true);
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "�û���������������");
			//this.jtf1.setText("");
			this.jpf1.setText("");
			this.jtf1.requestFocus();
		}
	}

}
