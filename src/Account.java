import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Account extends JFrame implements ActionListener{
	private JButton back;
	public String userinfo;
	public Account(String userInfo) {
		
		super("Pay Your bill");

		userinfo=userInfo;
		setLayout(new GridLayout(7,2));
		
		JLabel nameLabel= new JLabel("NID");
		add(nameLabel);	
		String NID= wordReturn(userInfo,10);
		
		JLabel nameLabel1=new JLabel(NID);
		add(nameLabel1);
		
		
		JLabel obj=new JLabel("USER NAME");
		add(obj);
		String firstName= wordReturn(userInfo,0);
		String lastName = firstName+ wordReturn(userInfo, 2) ;
		JLabel obj1=new JLabel(lastName);
		add(obj1);
		
		JLabel obj2=new JLabel("ADDRESS");
		add(obj2);
		String address= wordReturn(userInfo,4);
		JLabel objo = new JLabel(address);
		add(objo);
		
		JLabel obj3=new JLabel("Email Address");
		add(obj3);
		String email= wordReturn(userInfo,6);
		JLabel obj4=new JLabel(email);
		add(obj4);
		
		JLabel obj5=new JLabel("MOBILE NUMBER");
		add(obj5);
		String mobile= wordReturn(userInfo,8);
		JLabel obj6=new JLabel(mobile);
		add(obj6);
		
		JLabel space2 = new JLabel("");
		add(space2);
		JLabel space3 = new JLabel("");
		add(space3);
		
		back = new JButton("BACK");
		add(back);
		back.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			this.setVisible(false);
			MainPage J = new MainPage(userinfo);
			
			J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			J.setSize(500, 250);
			J.setVisible(true);
		}
	}
	
	public String wordReturn(String userInfo,int index) {
		String x;
		String[] wordss = userInfo.split(" ");
		
		return wordss[index];
	}

}