import java.util.*;

public class FileWord {
	public Formatter x;
	
	public void openFile() {
		try {
			x= new Formatter("savedInformation.txt");
		}
		catch(Exception e){
			System.out.println("File cant open");
		}
	}
	
	public void closeFile() {
		x.close();
	}
	
}
