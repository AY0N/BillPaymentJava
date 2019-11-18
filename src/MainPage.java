import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainPage extends JFrame implements ActionListener{
	
	private String userInfo;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	
	public MainPage(String passtofile) {
		
		super("Bill information");
		
		userInfo=passtofile;
		
		setLayout(new GridLayout(7, 1));
		
		JLabel space1 = new JLabel("");
		add(space1);

		 button1 = new JButton("Account");
		 button1.setBackground(Color.black);
		 button1.setForeground(Color.red);
		add(button1);
		button1.addActionListener(this);
		
		 button2 = new JButton("Balance");
		 button2.setBackground(Color.black);
		 button2.setForeground(Color.red);
		add(button2);
		button2.addActionListener(this);
		
		 button3 = new JButton("About");
		 button3.setBackground(Color.black);
		 button3.setForeground(Color.red);
		add(button3);
		button3.addActionListener(this);
		
		 button4 = new JButton("Support");
		 button4.setBackground(Color.blue);
		 button4.setForeground(Color.yellow);
		add(button4);
		button4.addActionListener(this);
		
		 button5 = new JButton("Sign Out");
		 button5.setBackground(Color.red);
		 button5.setForeground(Color.black);
			add(button5);
			button5.addActionListener(this);
			
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==button1) {
			this.setVisible(false);
			Account J = new Account(userInfo);
			
			J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			J.setSize(700, 225);
			J.setVisible(true);
		}
		
		if(e.getSource()==button2) {
			this.setVisible(false);
			Balance J = new Balance(userInfo);
			
			J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			J.setSize(700, 225);
			J.setVisible(true);
		}
		
		if(e.getSource()==button3) {
			this.setVisible(false);
			About J = new About();
			
			J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			J.setSize(700, 225);
			J.setVisible(true);
		}
		
		if(e.getSource()==button4) {
			this.setVisible(false);
			Support J = new Support(userInfo);
			
			J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			J.setSize(700, 225);
			J.setVisible(true);
		}
		
		if(e.getSource()==button5) {
			this.setVisible(false);
			homepage J = new homepage(false);

			J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			J.setSize(700, 225);
			J.setVisible(true);
		}
		
	}
	
}