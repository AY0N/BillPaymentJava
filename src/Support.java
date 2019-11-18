import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Support extends JFrame implements ActionListener{
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	String userInfo;
	public Support(String userinfo){
		super("Support");
		setLayout(new GridLayout(6, 1));
		userInfo=userinfo;
		JLabel space1 = new JLabel("");
		add(space1);

		 button1 = new JButton("Account not recharged?");
		 button1.setBackground(Color.black);
		button1.setForeground(Color.red);
		add(button1);
		button1.addActionListener(this);
		
		 button2 = new JButton("Electric meter not working?");
		 button2.setBackground(Color.black);
		button2.setForeground(Color.red);
		add(button2);
		button2.addActionListener(this);
		
		 button3 = new JButton("Others");
		 button3.setBackground(Color.black);
		button3.setForeground(Color.red);
		add(button3);
		button3.addActionListener(this); 
		
		 button4 = new JButton("BACK");
		 button4.setBackground(Color.blue);
		button4.setForeground(Color.yellow);
		add(button4);
		button4.addActionListener(this); 
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {
			this.showMessage();	
		}
		if(e.getSource()==button2) {
			this.showMessage();			
		}
		if(e.getSource()==button3) {
			this.showMessage();			
		}
		if(e.getSource()==button4) {
			this.setVisible(false);
			MainPage J = new MainPage(userInfo);
			
			J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			J.setSize(500, 250);
			J.setVisible(true);
		}
	}
	public void showMessage() {
		JOptionPane.showMessageDialog(null, "Please Call: 01866-980990", "Support", JOptionPane.PLAIN_MESSAGE);
	}
	
	
}	