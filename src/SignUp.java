import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JFrame implements ActionListener{
	
	private JTextField nameText;
	private JTextField nameText2;
	private JTextField Address1;
	private JTextField Address2;
	private JTextField MN1;
	private JPasswordField passField;
	private JTextField NID1;
	private JButton save;
	private JButton back;
	
	
	public SignUp() {
		
		super("Pay Your Bill");
		
		setLayout(new GridLayout(9, 2));
		
		JLabel FirstName = new JLabel("First Name");
		FirstName.setForeground(Color.blue);
		add(FirstName);
		nameText = new JTextField();
		nameText.setBackground(Color.yellow);
		
		add(nameText);
		
		JLabel LastName = new JLabel("Last Name");
		LastName.setForeground(Color.blue);
		add(LastName);
		nameText2 = new JTextField();
		nameText2.setBackground(Color.yellow);
		add(nameText2);
		
		JLabel Address = new JLabel("Address");
		Address.setForeground(Color.blue);
		add(Address);
		 Address1 = new JTextField();
		 Address1.setBackground(Color.yellow);
		add(Address1);
		
		JLabel EAddress = new JLabel("E-mail");
		EAddress.setForeground(Color.blue);
		add(EAddress);
		 Address2 = new JTextField();
		 Address2.setBackground(Color.yellow);
		add(Address2);
		
		JLabel MN = new JLabel("Mobile no.");
		MN.setForeground(Color.blue);
		add(MN);
		 MN1 = new JTextField();
		 MN1.setBackground(Color.yellow);
		add(MN1);
		
		JLabel NID = new JLabel("NID no.");
		NID.setForeground(Color.blue);
		add(NID);
		 NID1 = new JTextField();
		 NID1.setBackground(Color.yellow);
		add(NID1);
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setForeground(Color.red);
		add(passLabel);
		 passField = new JPasswordField();
		 passField.setBackground(Color.orange);
		add(passField);
		
		JLabel space1 = new JLabel("");
		add(space1);
		JLabel space2 = new JLabel("");
		add(space2);
		
//		Extra test
		
		 save = new JButton("Sign up");
		 save.setBackground(Color.green);
		 save.setForeground(Color.yellow);
		add(save);
		save.addActionListener(this);
		 back = new JButton("Back");
		 back.setForeground(Color.red);
		 back.setBackground(Color.yellow);
		add(back);
		back.addActionListener(this);	
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==save) {
			File f = new File("savedInformation.txt");
			File f2 = new File("savedMoney.txt");
			if(nameText.getText().isEmpty() || nameText2.getText().isEmpty() ||Address1.getText().isEmpty() || Address2.getText().isEmpty() || MN1.getText().isEmpty() || NID1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please fill all fields", "Fill your fields", JOptionPane.PLAIN_MESSAGE);
			}
			else {
				String name1=(nameText.getText().replaceAll("\\s+", ""));
				String name2=(nameText2.getText().replaceAll("\\s+", ""));;
				String Address=(Address1.getText().replaceAll("\\s+", ""));;
				String email=(Address2.getText().replaceAll("\\s+", ""));;
				String mobile=(MN1.getText().replaceAll("\\s+", ""));;
				String NID=(NID1.getText().replaceAll("\\s+", ""));;
				
				String content = name1 +"  "+ name2 +"  "+ Address+ "  "+email + "  "+mobile + "  "+NID ;
				try {
					filewrite(content+"\n",f);
					filewrite(name1+" "+"0"+"\n",f2);
					JOptionPane.showMessageDialog(null, "Added!", "Pay Your Bill", JOptionPane.PLAIN_MESSAGE);
					
				} catch (IOException e1) {
		
					e1.printStackTrace();
				}
			}
		}
		if(e.getSource()==back) {
			this.setVisible(false);
			homepage J = new homepage(false);

			J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			J.setSize(700, 225);
			J.setVisible(true);
		}

	}
	
	public static void filewrite(String content, File f) throws IOException{
		FileWriter files = new FileWriter(f,true);
		files.write(content);
		files.close();
		
	}
}

