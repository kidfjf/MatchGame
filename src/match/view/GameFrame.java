package match.view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.TextField;
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
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

import match.level.Level1;
import match.user.User;

public class GameFrame extends JFrame {
	JLabel Pic;
	int x,y,m=5;
	String id="";
	User player = new User();
	TextField tField = new TextField(30);
	public GameFrame(User player) {
		// ��ʼ����Ϸ��������
		this.player = player;
		this.id=player.getUsername();
		initComponents();
		init();
	}

	private void init() {
		this.setSize(900, 600);
		this.setLocation(100, 100);
		this.setVisible(true);
		this.setTitle(id+"�Ļ����Ϸ");
		this.setResizable(false);
	//	this.setLayout(null);
	}

	//// ��ʼ����¼��������
	public void initComponents() {
		ImageIcon i1 = new ImageIcon("./img/no0.png");
		JLabel label=new JLabel(i1);
	//	label.setOpaque(false);
		label.setBounds(0,0,i1.getIconWidth(),i1.getIconHeight());
		JLabel txt = new JLabel("�ƶ������ͼ�����һ�������");
		txt.setBounds(650, 150, 200, 50);
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		panel2.add(tField);
	//	panel.setLayout(null);
	//	panel.setBounds(377, 203, 600, 60);
	//	panel.setSize(900,600);
	//	panel.setBounds(30,30,300,50);
		Pic = new JLabel(new ImageIcon("./img/match-.png"));
		panel.add(Pic);
		panel.setOpaque(false);
		JButton button = new JButton("��ʾ");
		JButton button1 = new JButton("��һ��");
	//	button.setLayout(null);
	//	button.setBorderPainted(false);
	//	button.setContentAreaFilled(false);
		button.setBounds(650,350,60,60);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Tips(evt);
			}
		});
		button1.setBounds(750, 350, 80, 60);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Next(evt);
			}
		});
	    Pic.addMouseListener(new MouseAdapter() {
	    	public void mousePressed(MouseEvent e) {
	    		x = e.getX();
	    		y = e.getY();
	    	}
		});  
	    Pic.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				gogogo(e);}
		});
	  //  String string = Pic.getX() + "��" + Pic.getY() ;
	 //   tField.setText(string);
	    this.add(label);
	    this.add(txt);
	    this.add(button);
	    this.add(button1);
	    this.add(panel);
	 //   this.add(panel2,"South");
	}
	class MyMouseInputAdapter extends MouseInputAdapter{
		   Point point=new Point(0,0); //�����
		      
		   public void mousePressed(MouseEvent e)
		   {
		       point=SwingUtilities.convertPoint(Pic,e.getPoint(),Pic.getParent()); //�õ���ǰ�����
		   }
		      
		   public void mouseDragged(MouseEvent e)
		   {
		      Point newPoint=SwingUtilities.convertPoint(Pic,e.getPoint(),Pic.getParent()); //ת������ϵͳ
		      Pic.setLocation(Pic.getX()+(newPoint.x-point.x),Pic.getY()+(newPoint.y-point.y)); //���ñ�ǩͼƬ����λ��
		      point=newPoint; //���������
			  if(Pic.getX() > 350 && Pic.getX() < 380) {
				  if(Pic.getY() > 240 && Pic.getY() < 320) {
					Object[] options ={ "������","�Ҳ�������" };
					m = JOptionPane.showOptionDialog(null, "�ɹ�ͨ��", "�����Ϸ",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				 }
			  }
		  }

	   }
	private void Tips(ActionEvent e) {
		JOptionPane.showMessageDialog(null,"�����м���4�����","��ʾ",JOptionPane.PLAIN_MESSAGE);
	}
	private void Next(ActionEvent e) {
		if(m==0) {
			Level1 L1 = new Level1(player);
			this.dispose();
		}
		else {
			Object[] options ={ "��һ��","��������" };
			int n = JOptionPane.showOptionDialog(null, "�㻹δͨ�أ�ȷ��Ҫ������һ����",id,JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			if(n==0) {
				Level1 L1 = new Level1(player);
				this.dispose();
			}
		}
	}
	private void gogogo(MouseEvent e) {
		JLabel match = (JLabel)e.getSource();
		match.setLocation(match.getX()+e.getX()-x, match.getY()+e.getY()-y);
		if(match.getX() > 350 && match.getX() < 380) {
			  if(match.getY() > 240 && match.getY() < 320) {
				Object[] options ={ "��һ��","�Ҳ�������" };
				m = JOptionPane.showOptionDialog(null, "�ɹ�ͨ��", "�����Ϸ",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				if(m==1) {
				this.dispose();}
				else if (m==0){
					Level1 L1 = new Level1(player);
					this.dispose();
				}
			}
		}
	}
}
		
		