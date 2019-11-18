import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Recharge {
	private String userInfo;
	private int money;
	public Recharge(String userinfo) {
		userInfo=userinfo;
		money = getCurrentBalance();
		
	}
	public void addAmount(int amount) {
		money = money+ amount;
		String x;
		String[] words = userInfo.split(" ");
		x=words[0].toUpperCase();
		File f2 = new File("savedMoney.txt");
		try {
			
			filewrite(x+" "+money+"\n",f2);
			JOptionPane.showMessageDialog(null, "Added!", "Pay Your Bill", JOptionPane.PLAIN_MESSAGE);
			
			
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		
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
	public static void filewrite(String content, File f) throws IOException{
		FileWriter files = new FileWriter(f,true);
		files.write(content);
		files.close();
		
	}
	
}
