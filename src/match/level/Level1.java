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

public class Level1 extends JFrame {
	JLabel match1,match2,match3,match4,match5,match6,match7,match8;
	User player = new User();
	String id="";
	static int x,y,q=2;
	public Level1(User player) {
		// 初始化游戏界面各组件
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
		this.setTitle(id+"的第一关");
		this.setResizable(false);
		
	}

	//// 初始化登录界面各组件
	public void initComponents() {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 900, 600);
		panel.setOpaque(false);
		JLabel txt = new JLabel("移动火柴让锤子变成小鱼");
		txt.setBounds(650, 150, 200, 50);
		match1 = new JLabel(new ImageIcon("./img/match45.png"));
		match2 = new JLabel(new ImageIcon("./img/match135.png"));
		match3 = new JLabel(new ImageIcon("./img/match45.png"));
		match4 = new JLabel(new ImageIcon("./img/match135.png"));
		match5 = new JLabel(new ImageIcon("./img/match45.png"));
		match6 = new JLabel(new ImageIcon("./img/match135.png"));
		match7 = new JLabel(new ImageIcon("./img/match45.png"));
		match8 = new JLabel(new ImageIcon("./img/match135.png"));
		match1.setBounds(36,310,189,201);
		match2.setBounds(48,204,183,167);
		match3.setBounds(163,192,189,201);
		match4.setBounds(176,330,183,167);
		match5.setBounds(303,74,189,201);
		match6.setBounds(177,83,183,167);
		match7.setBounds(292,320,189,201);
		match8.setBounds(308,205,183,167);
		panel.add(match1);
		panel.add(match2);
		panel.add(match3);
		panel.add(match4);
		panel.add(match5);
		panel.add(match6);
		panel.add(match7);
		panel.add(match8);
		JButton button = new JButton("提示");
		button.setBounds(650,350,60,60);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Tips(evt);
			}
		});
		JButton button1 = new JButton("下一关");
		button1.setBounds(750, 350, 80, 60);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Next(evt);
			}
		});
//		ImageIcon ii = new ImageIcon("./img/match.png");
//		JButton button = new JButton(ii);
//		button.setBorderPainted(false);
//		button.setContentAreaFilled(false);
//		button.setMargin(new Insets(10,10,10,10));
//		button.setBounds(100,10,166,351);
//		panel.add(button);
	    match1.addMouseListener(new MouseAdapter() {
	    	public void mousePressed(MouseEvent e) {
	    		x = e.getX();
	    		y = e.getY();
	    	}
		});  
	    match1.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO 自动生成的方法存根
				
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
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO 自动生成的方法存根
				JLabel match = (JLabel)e.getSource();
				match.setLocation(match.getX()+e.getX()-x, match.getY()+e.getY()-y);
			}
		});
	    match3.addMouseListener(new MouseAdapter() {
	    	public void mousePressed(MouseEvent e) {
	    		x = e.getX();
	    		y = e.getY();
	    	}
		});  
	    match3.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO 自动生成的方法存根
				JLabel match = (JLabel)e.getSource();
				match.setLocation(match.getX()+e.getX()-x, match.getY()+e.getY()-y);
			}
		});
	    match4.addMouseListener(new MouseAdapter() {
	    	public void mousePressed(MouseEvent e) {
	    		x = e.getX();
	    		y = e.getY();
	    	}
		});  
	    match4.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO 自动生成的方法存根
				JLabel match = (JLabel)e.getSource();
				match.setLocation(match.getX()+e.getX()-x, match.getY()+e.getY()-y);
			}
		});
	    match5.addMouseListener(new MouseAdapter() {
	    	public void mousePressed(MouseEvent e) {
	    		x = e.getX();
	    		y = e.getY();
	    	}
		});  
	    match5.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO 自动生成的方法存根
				JLabel match = (JLabel)e.getSource();
				match.setLocation(match.getX()+e.getX()-x, match.getY()+e.getY()-y);
			}
		});
	    match6.addMouseListener(new MouseAdapter() {
	    	public void mousePressed(MouseEvent e) {
	    		x = e.getX();
	    		y = e.getY();
	    	}
		});  
	    match6.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO 自动生成的方法存根
				JLabel match = (JLabel)e.getSource();
				match.setLocation(match.getX()+e.getX()-x, match.getY()+e.getY()-y);
			}
		});
	    match7.addMouseListener(new MouseAdapter() {
	    	public void mousePressed(MouseEvent e) {
	    		x = e.getX();
	    		y = e.getY();
	    	}
		});  
	    match7.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO 自动生成的方法存根
				JLabel match = (JLabel)e.getSource();
				match.setLocation(match.getX()+e.getX()-x, match.getY()+e.getY()-y);
			}
		});
	    match8.addMouseListener(new MouseAdapter() {
	    	public void mousePressed(MouseEvent e) {
	    		x = e.getX();
	    		y = e.getY();
	    	}
		});  
	    match8.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO 自动生成的方法存根
				JLabel match = (JLabel)e.getSource();
				match.setLocation(match.getX()+e.getX()-x, match.getY()+e.getY()-y);
			}
		});
	    this.add(panel);
	    this.add(txt);
	    this.add(button);
	    this.add(button1);
	}

	private void Tips(ActionEvent e) {
		JOptionPane.showMessageDialog(null,"移动最左边的火柴","提示",JOptionPane.PLAIN_MESSAGE);
	}
	private void gogogo(MouseEvent e) {
		JLabel match = (JLabel)e.getSource();
		match.setLocation(match.getX()+e.getX()-x, match.getY()+e.getY()-y);
		if(match.getX() > 410 && match.getX() < 453) {
			  if(match.getY() > 170 && match.getY() < 220) {
				Object[] options ={ "下一关","我不想玩了" };
				q = JOptionPane.showOptionDialog(null, "成功通关", "火柴游戏",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				if(q==1) {
				this.dispose();}
				else if (q==0){
					Level2 L2 = new Level2(player);
					this.dispose();
				}
			}
		}
	}
	private void Next(ActionEvent e) {
		if(q==0) {
			Level2 L2 = new Level2(player);
			this.dispose();
		}
		else {
			Object[] options ={ "下一关","我再试试" };
			int n = JOptionPane.showOptionDialog(null, "你还未通关，确定要进入下一关吗",id,JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			if(n==0) {
				Level2 L2 = new Level2(player);
				this.dispose();
			}
		}
	}
}