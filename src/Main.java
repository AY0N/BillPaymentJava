import javax.swing.JFrame;

public class Main {
	
	public static void main(String [] args) {
		boolean firstTime=true;
		homepage J = new homepage(firstTime);

		
		J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		J.setSize(700, 225);
		J.setVisible(true);
		
	}

}
