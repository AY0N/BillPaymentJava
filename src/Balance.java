import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Balance extends JFrame implements ActionListener{
	
	
	public String userInfo;
	public JButton back;
	public JButton recharge;
	public JTextField balance;
	public int amount;
	
	public Balance(String userinfo) {
		
		super("Pay Your Bill");
		userInfo=userinfo;
		setLayout(new GridLayout(4, 1));
		int money = getCurrentBalance();
		JLabel current = new JLabel("Current Balance: "+money);
		current.setForeground(Color.green);
		add(current);
		balance = new JTextField();
		add(balance);
		 recharge = new JButton("Recharge");
		 recharge.setForeground(Color.white);
		 recharge.setBackground(Color.green);
		add(recharge);
		recharge.addActionListener(this);
		 back = new JButton("Back");
		 back.setBackground(Color.black);
		 back.setForeground(Color.red);
		add(back);
		back.addActionListener(this);
		
		
		
	}
	public int getCurrentBalance() {
		int money=0;
		String x;
		String[] words = userInfo.split(" ");
		x=words[0].toUpperCase();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("savedMoney.txt"));
			String line = reader.readLine();
			String[] wordss;
			
			while(line!=null) {

				if(!line.isEmpty()) {	
					wordss = line.split(" ");
					if(wordss.length>0) {
						if(x.equals(wordss[0].toUpperCase())){
							 money=Integer.parseInt(wordss[1]);
						}
					}
				}
				line=reader.readLine();
				
			}
			reader.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return money;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==recharge) {
			if(isInteger(balance.getText().replaceAll("\\s+", ""))==false) {
				JOptionPane.showMessageDialog(null, "Please enter valid digits", "Error", JOptionPane.PLAIN_MESSAGE);
			}
			else {
			
				Recharge g = new Recharge(userInfo);
				amount=Integer.parseInt(balance.getText().replaceAll("\\s+", ""));
				g.addAmount(amount);
				this.setVisible(false);
				Balance J = new Balance(userInfo);
				
				J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				J.setSize(700, 225);
				J.setVisible(true);
			}
		}
		if(e.getSource()==back) {
			this.setVisible(false);
			MainPage J = new MainPage(userInfo);
			
			J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			J.setSize(500, 250);
			J.setVisible(true);
		}
		
		
	}
	public boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
	
}
	

