import java.math.BigDecimal;
import java.util.Scanner;

public class MainView {
	MainController controller; 
	
	public String welcomeScreen() {
	String message;
	message = "Welcome to Event Builder";
	message+= "\n for Optional questions please enter NO if N/A";
			return message;
	}
	
	public void result()
	{
		String result;
		result = "The result for your event based on your parameters are as followed.";
				
		System.out.println(result);
	}
	
}
