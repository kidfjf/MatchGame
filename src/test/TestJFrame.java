package test;

import java.awt.BorderLayout;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.awt.event.WindowAdapter;  
import java.awt.event.WindowEvent;  
  
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JTextField;  
  
public class TestJFrame extends JFrame{  
    private SecondJFrame second = new SecondJFrame();  
    public TestJFrame() {  
        this.setLayout(new BorderLayout());  
          
        final JTextField text = new JTextField("first field");  
        this.add(text, BorderLayout.CENTER);  
          
        JButton button = new JButton("改变另一个JFrame的值");  
        button.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                String first = text.getText();  
                second.changeTextValue(first);  
            }  
        });  
        this.add(button, BorderLayout.SOUTH);  
        this.setSize(300, 100);  
        this.setLocation(200, 200);  
        this.setVisible(true);  
          
        this.addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent e)   
            {                  
                System.exit(0);  
            }  
        });  
    }  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        new TestJFrame();  
    }  
  
}  
  
class SecondJFrame extends JFrame {  
    JTextField text = new JTextField("second field");  
    public SecondJFrame() {  
        this.setLayout(new BorderLayout());  
        this.add(text, BorderLayout.CENTER);  
        this.setSize(200, 100);  
        this.setVisible(true);  
    }  
      
    public void changeTextValue(String newValue) {  
        text.setText(newValue);  
    }  
}  
