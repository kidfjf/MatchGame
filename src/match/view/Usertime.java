package match.view;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import match.user.User;
public class Usertime extends JFrame {
	User player = new User();
	String id="";
	public Usertime(User player){
		this.player = player;
		this.id=player.getUsername();
		initComponents();
		init();
	}
	private void init() {
		this.setLocation(200, 200);
		this.setSize(400, 250);
		this.setVisible(true);
		this.setTitle("��ҷ���");
		this.setResizable(false);
	}

	//// ��ʼ����¼��������
	public void initComponents() {
		// ��������
		JLabel txt = new JLabel();
		txt.setText(player.getUsername() +":"+player.getTime());
		this.setLayout(new GridLayout(1, 1));
		this.add(txt);
	}
}
