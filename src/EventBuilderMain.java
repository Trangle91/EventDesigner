import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;
public class EventBuilderMain {

	public static void main(String[] args) {
		
		MainView view = new MainView();
		ClientEventBuilder builder;
		
		System.out.println(view.welcomeScreen());
		System.out.println("What is the client's name"?);
		System.out.println("LastName?");
		Scanner scan = new Scanner(System.in);
		String first_name= scan.nextLine();
		System.out.println("Last name?");
		String last_name = scan.nextLine();
		System.out.println("Phone Number?");
		String phone_num = scan.nextLine();
		System.out.println("(Optional)Partner's Name?");
		String partner_name = scan.next();
		Optional<String> partnerName = Optional.ofNullable(partner_name);
	

		Client currentclient = new Client(first_name, last_name,partnerName, phone_num, builder);
		
		System.out.println("Date of the Event? (YEAR-MONTH-DAY");
		String date = scan.nextLine();
		DateTimeFormatter format = DateTimeFormatter.ISO_DATE;
		LocalDate eventDate= LocalDate.parse(date, format);
		
		System.out.println("Budget?");
		BigDecimal budgetAmount = scan.nextBigDecimal();
		System.out.println("(Optional) Guest count?");
		int guest_count = scan.nextInt();
		Optional<Integer> guestCount = Optional.ofNullable(guest_count);
		System.out.println("(Optional) Table count?");
		int table_count = scan.nextInt();
		Optional<Integer> tableCount = Optional.ofNullable(table_count);
		
		System.out.println("(Optional) Event theme?");
		String theme = scan.nextLine();
		Optional <String> eventTheme = Optional.ofNullable(theme);
		
		System.out.println("(Optional) Color Palette?");
		String color_palette = scan.nextLine();
		Optional <String> colorPalette = Optional.ofNullable(color_palette);
		
		ClientEvent currentEvent= currentclient.createEvent(eventDate, budgetAmount, guestCount, tableCount, eventTheme, colorPalette);

		
		
		

	}

}
