import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class EventBuilderMain {
	static Client currentclient;
	public static void main(String[] args) throws IOException {
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
	

		currentclient = new Client(first_name, last_name,partnerName, phone_num, builder);
		
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
		
		System.out.println("Table count?");
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
	
		
		
		System.out.println("Please choose Arrangements from the list below.");
		System.out.println(LargeFloralRingArrangement.Instance.ArrangementReport());
		JFrame frame = new JFrame("Large FLoral Ring Arrangement(1)");
		ImageIcon lfra = new ImageIcon("images/LargeFloralHeavyRing.jpg");
		
		JLabel label = new JLabel(lfra);
		frame.add(label);
		frame.setSize(lfra.getIconWidth(), lfra.getIconHeight());
		frame.setVisible(true);
		System.out.println(VotiveArrangement.Instance.ArrangementReport());
		JFrame frame1 = new JFrame("Votive Arrangement(5)");
		
		ImageIcon votive = new ImageIcon("images/VotivesAndGreenery.jpg");
		
		JLabel label1 = new JLabel(votive);
		frame1.setSize(votive.getIconWidth(), votive.getIconHeight());
		frame1.add(label1);
		frame1.setVisible(true);
		System.out.println(TallAnchorArrangement.Instance.ArrangementReport());
		JFrame frame2 = new JFrame("Tall Anchor Arrangement (4)");
		ImageIcon taa = new ImageIcon("images/TallAnchorPiece.jpg");
		
		JLabel label2 = new JLabel(taa);
		frame2.setSize(taa.getIconWidth(), taa.getIconHeight());
		frame2.add(label2);
		frame2.setVisible(true);
		System.out.println(LowFloralArrangement.Instance.ArrangementReport());
		JFrame frame3 = new JFrame("Low Floral Arrangement (2)");
		ImageIcon lfa= new ImageIcon("images/LowFloralHeavyArrangement.jpg");
		JLabel label3 = new JLabel(lfa);
		frame3.setSize(lfa.getIconWidth(), lfa.getIconHeight());
		frame3.add(label3);
		frame3.setVisible(true);
		System.out.println(SmallFloralRingArrangement.Instance.ArrangementReport());
		JFrame frame4 = new JFrame("Samll Floral Ring Arrangement (3)");
		ImageIcon sfra= new ImageIcon("images/SmallFloralRing.jpg");
		JLabel label4 = new JLabel(sfra);
		frame4.setSize(sfra.getIconWidth(), sfra.getIconHeight());
		frame4.add(label4);
		frame4.setVisible(true);
		
	
		view.selectArrangementType();
	int arrangementChoice;
	do {
		
		arrangementChoice = scan.nextInt();
		getResults(arrangementChoice);
	} while (arrangementChoice != 0);
	
	report.printEventReport(currentclient, event);		
	//report.printEventResults(currentclient);

	
	}
	
	public static void getResults(int choice)
	{
		Object arrange = null;
		switch (choice) {
		case 1: arrange = LargeFloralRingArrangement.Instance;
		break;
		case 2: arrange = VotiveArrangement.Instance;
		break;
		case 3: arrange = TallAnchorArrangement.Instance; //cannot select just tall arrangement
		break;
		case 4: arrange = LowFloralArrangement.Instance;
		break;
		case 5: arrange = SmallFloralRingArrangement.Instance;
		currentclient.event.designEvent(arrange);
	}		
				
				
	
	}
}

