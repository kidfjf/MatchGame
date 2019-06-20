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
		this.setTitle("玩家分数");
		this.setResizable(false);
	}

	//// 初始化登录界面各组件
	public void initComponents() {
		// 定义各组件
		JLabel txt = new JLabel();
		txt.setText(player.getUsername() +":"+player.getTime());
		this.setLayout(new GridLayout(1, 1));
		this.add(txt);
	}
}
