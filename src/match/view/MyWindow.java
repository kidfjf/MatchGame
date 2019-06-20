package match.view;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import match.user.User;

public class MyWindow<JButtonListener> extends JFrame{
     public MyWindow(){
    	 final Frame f = new Frame ("火柴游戏");
    	 int width = 900;
 	 	 int height = 600;
 	 	 int x = 100;
 		 int y = 100;
 		 f.setBounds(x, y, width, height);
 		 f.addWindowListener(new WindowAdapter() {
 			 public void windowClosing(WindowEvent e) {
 				 super.windowClosing(e);
 				 f.dispose();
 			 }
 		 });
 		 f.setLayout(null);
 		 ImageIcon i1 = new ImageIcon("./img/beijing.png");
 		 JLabel label=new JLabel(i1);
 		 label.setOpaque(false);
 		 label.setBounds(0,0,i1.getIconWidth(),i1.getIconHeight());
 		 JPanel panel = new JPanel();
 		 panel.setSize(900,600);
 		 panel.setLayout(null);
 		 JButton button1 = new JButton("用户登录/注册");
		 JButton button2 = new JButton("以游客身份开始游戏");
		 button1.setBounds(200,250,200,50);
		 button2.setBounds(500,250,200,50);
		 button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					regist_jbActionPerformed(evt);
				}
			});
		 button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					game_jbActionPerformed(evt);
					f.dispose();
				}
			});
		 panel.add(button1);
		 panel.add(button2);
		 panel.add(label);
		 f.add(panel);
		 f.setVisible(true);
     }
     private void regist_jbActionPerformed(ActionEvent e) {
 		RegistFrame rf = new RegistFrame();
 		rf.setVisible(true);
 		 this.dispose();
 	}
     private void game_jbActionPerformed(ActionEvent e) {
    	String id = "游客";
    	User u = new User();
    	u.setUsername(id);
  		GameFrame ga = new GameFrame(u);
  		ga.setVisible(true);
  		this.dispose();
  	}
 	
}
     

