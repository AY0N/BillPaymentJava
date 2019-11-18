import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame implements ActionListener{
	
	public JButton back;
	public String userinfo;
	
	public About() {
		
		super("Pay Your Bill");
		
		setLayout(new GridLayout(3, 1));
		
		JLabel space = new JLabel ("");
		add(space);
			
		JLabel about = new JLabel ("This program is about recharging your bills. It's an easy way to access your own account. Have a great time!");
		add(about);

		back = new JButton("Back");
		back.setForeground(Color.red);
		back.setBackground(Color.black);
		add(back);
		back.addActionListener(this);
		
	}

		
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			this.setVisible(false);
			MainPage J = new MainPage(userinfo);

			J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			J.setSize(700, 225);
			J.setVisible(true);
		}		
	}

}
