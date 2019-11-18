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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class homepage extends JFrame implements ActionListener{
	public JButton reset;
	public JButton save;
	private JTextField nameText1;
	private String passtofile;
	
	public homepage(boolean firstTime) {
		
		super("Pay Your Bill");
		if(firstTime==true) {
			JOptionPane.showMessageDialog(null, "Welcome User!", "Pay Your Bill", JOptionPane.PLAIN_MESSAGE);
		}
		setLayout(new GridLayout(5, 2));
		
		JLabel nameLabel = new JLabel("Input user name");
		nameLabel.setBackground(Color.black);
		nameLabel.setForeground(Color.red);
		add(nameLabel);
		nameText1 = new JTextField(20);
		nameText1.setBackground(Color.yellow);
		add(nameText1);
		
		JLabel nameID = new JLabel("Input NID");
		nameID.setForeground(Color.red);
		nameID.setBackground(Color.black);
		add(nameID);
		JTextField nameText2 = new JTextField();
		nameText2.setBackground(Color.yellow);
		add(nameText2);
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setBackground(Color.red);
		passLabel.setForeground(Color.green);
		add(passLabel);
		JPasswordField passField = new JPasswordField();
		passField.setBackground(Color.red);
		add(passField);
		
		JLabel space1 = new JLabel("");
		add(space1);
		JLabel space2 = new JLabel("");
		add(space2);
		
		reset = new JButton("GO!");
		reset.setBackground(Color.green);
		reset.setForeground(Color.white);
		add(reset);
		reset.addActionListener(this);
		
		
		save = new JButton("Sign up");
		save.setForeground(Color.red);
		save.setBackground(Color.black);
		add(save);
		save.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==reset) {
			String inputtedname = nameText1.getText().replaceAll("\\s+", "").toUpperCase();
			boolean existsInfile = false;
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader("savedInformation.txt"));
				String line = reader.readLine();
				String[] wordss;
				
				while(line!=null) {

					if(!line.isEmpty()) {	
						wordss = line.split(" ");
						if(wordss.length>0) {
							if(inputtedname.equals(wordss[0].toUpperCase())){
								existsInfile = true;
								passtofile = line;
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
			if(existsInfile==true) {
				this.setVisible(false);
				MainPage J = new MainPage(passtofile);
				
				J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				J.setSize(500, 250);
				J.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "Sorry user name does not exist", "Error", JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		if(e.getSource()==save) {
			this.setVisible(false);
			SignUp J = new SignUp();
			
			J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			J.setSize(700, 225);
			J.setVisible(true);
		}
		
	}
	
	
	
	

}
