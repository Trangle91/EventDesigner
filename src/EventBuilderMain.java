import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;
public class EventBuilderMain {

	public static void main(String[] args) {
		final EventReport report = new Reports();
		MainView view = new MainView();
		final ClientEventBuilder builder = new BuilderImpl();
		Scanner scan = new Scanner(System.in);
		System.out.println(view.welcomeScreen());
		System.out.println("What is the client's name?");
		System.out.println("First Name");
		
		String first_name= scan.nextLine();
		System.out.println("Last name?");
		String last_name = scan.nextLine();
		System.out.println("Phone Number?");
		String phone_num = scan.nextLine();
		System.out.println("(Optional)Partner's Name?");
		String partner_name = scan.nextLine();
		if (partner_name.equalsIgnoreCase("no"))
			partner_name = null;
		Optional<String> partnerName = Optional.ofNullable(partner_name);
	

		Client currentclient = new Client(first_name, last_name,partnerName, phone_num, builder);
		
		System.out.println("Date of the Event? (YEAR-MONTH-DAY)?");
	
		String date = scan.nextLine();
		DateTimeFormatter format = DateTimeFormatter.ISO_DATE;
		LocalDate eventDate= LocalDate.parse(date, format);
		
		System.out.println("Budget?");
		BigDecimal budgetAmount = scan.nextBigDecimal();
		
		System.out.println("(Optional) Guest count?");
		String guestcount = scan.next();
		if(guestcount.equalsIgnoreCase("no"))
			guestcount=null;
		
		int guest_count = Integer.parseInt(guestcount);
		Optional<Integer> guestCount = Optional.ofNullable(guest_count);
		
		System.out.println("(Optional) Table count?");
		int tableCount = scan.nextInt();
	
		
		System.out.println("(Optional) Event theme?");
		String theme = scan.next();
		if (theme.equalsIgnoreCase("no"))
			theme = null;
		Optional <String> eventTheme = Optional.ofNullable(theme);
		
		System.out.println("(Optional) Color Palette?");
		String color_palette = scan.next();
		if (color_palette.equalsIgnoreCase("no"))
			color_palette = null;
		Optional <String> colorPalette = Optional.ofNullable(color_palette);
		
		//System.out.println(report.printClientReport(currentclient));

	ClientEvent event = currentclient.createEvent(eventDate, budgetAmount, guestCount, tableCount, eventTheme, colorPalette);
		report.printEventReport(currentclient, event);
		
		
		

	}

}
