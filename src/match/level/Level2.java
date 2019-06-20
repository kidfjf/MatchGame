package match.level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import match.user.User;
import match.view.Usertime;

public class Level2 extends JFrame {
	JLabel match1,match2,match3,match4,match5,match6,match7,match8;
	String id="";
	User player = new User();
	static int x,y,q;
	public Level2(User player) {
		// ��ʼ����Ϸ��������
		this.player = player;
		this.id=player.getUsername();
		player.setTime(100);
		initComponents();
		init();
	}

	private void init() {
		this.setLayout(null);
		this.setSize(900, 600);
		this.setLocation(100, 100);
		this.setVisible(true);
		this.setTitle(id+"�ĵڶ���");
		this.setResizable(false);
		
	}

	//// ��ʼ����¼��������
	public void initComponents() {
		ImageIcon i1 = new ImageIcon("./img/no2.png");
		JLabel label=new JLabel(i1);
		label.setBounds(0,0,i1.getIconWidth(),i1.getIconHeight());
		JLabel txt = new JLabel("���ӻ��ʹ��ʽ����");
		txt.setBounds(100, 50, 200, 50);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 900, 600);
		panel.setOpaque(false);
		JButton button = new JButton("��ʾ");
		button.setBounds(650,50,60,60);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Tips(evt);
			}
		});
		JButton button1 = new JButton("��һ��");
		button1.setBounds(750, 50, 80, 60);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Next(evt);
			}
		});
		match1 = new JLabel(new ImageIcon("./img/match021.png"));
		match2 = new JLabel(new ImageIcon("./img/match02-.png"));
		match1.setBounds(270,5,56,166);
		match2.setBounds(400,50,162,78);
		panel.add(match1);
		panel.add(match2);
	    match1.addMouseListener(new MouseAdapter() {
	    	public void mousePressed(MouseEvent e) {
	    		x = e.getX();
	    		y = e.getY();
	    	}
		});  
	    match1.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				gogogo(e);
			}
		});
	    match2.addMouseListener(new MouseAdapter() {
	    	public void mousePressed(MouseEvent e) {
	    		x = e.getX();
	    		y = e.getY();
	    	}
		});  
	    match2.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO �Զ����ɵķ������
				JLabel match = (JLabel)e.getSource();
				match.setLocation(match.getX()+e.getX()-x, match.getY()+e.getY()-y);
			}
		});
		this.add(label);
	    this.add(panel);
	    this.add(txt);
	    this.add(button);
	    this.add(button1);
	}
	private void Tips(ActionEvent e) {
		JOptionPane.showMessageDialog(null,"2x3=6","��ʾ",JOptionPane.PLAIN_MESSAGE);
	}
	private void gogogo(MouseEvent e) {
		JLabel match = (JLabel)e.getSource();
		match.setLocation(match.getX()+e.getX()-x, match.getY()+e.getY()-y);
		if(match.getX() > 637 && match.getX() < 653) {
			  if(match.getY() > 265 && match.getY() < 298) {
				Object[] options ={ "�鿴����","�Ҳ�������" };
				q = JOptionPane.showOptionDialog(null, "�ɹ�ͨ��", "�����Ϸ",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				if(q==1) {
				this.dispose();}
				else if (q==0){
					Usertime t1 = new Usertime(player);
					this.dispose();
				}
			}
		}
	}
	private void Next(ActionEvent e) {
		if(q==0) {
			Usertime t1 = new Usertime(player);
			this.dispose();
		}
		else {
			Object[] options ={ "��һ��","��������" };
			int n = JOptionPane.showOptionDialog(null, "�㻹δͨ�أ�ȷ��Ҫ������һ����",id,JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			if(n==0) {
				Usertime t1 = new Usertime(player);
				this.dispose();
			}
		}
	}
}
