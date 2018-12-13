import java.text.NumberFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public interface EventReport {
	
public String printClientReport(Client client);
void printEventResults(Client client, Florist florsit);
void printEventReport(Client Client, ClientEvent event);
void printFloristReport(Florist florist, Client client);
}
class Reports implements EventReport{
	
public Reports()
{
	
}
@Override

public String printClientReport(Client client)
{
	String clientreport;
	clientreport = "Client name: " + client.getClientName();
	String number = client.getPhoneNumber().replaceFirst("(\\d{3})(\\d{3})(\\d+)","($1) $2-$3");
	
	clientreport += "\nClient PhoneNumber: " + number;
	if(client.getPartnerName() == null)
		{clientreport += "\nClient partner: N/A";
			}
		else {
	clientreport += "\nClient partner: " + client.getPartnerName();}
	return clientreport;
}
@Override
public void printEventReport(Client Client, ClientEvent event) {
	System.out.println(printClientReport(Client));
	String eventReport="\n*********************************";
	eventReport += "\nYou've entered the following parameters for your event";
	eventReport += "\nDate (YEAR-MONTH-DAY): " + event.getEventDate();
	
	eventReport += "\nExpected Budget: " + NumberFormat.getCurrencyInstance().format(event.getBudgetAmount());
	eventReport += "\nTable Count: " + event.getTableCount();
	if (event.getGuestCount() != null) {
	eventReport += "\nGuest Count: " + event.getGuestCount();
	}
	if (event.getEventTheme() !=null)
	eventReport +="\nEvent Theme: " + event.getEventTheme();
	if(event.getColorPalette() != null) {
	eventReport += "\nColor Palette: " + event.getColorPalette() + "\n";
	}
	eventReport += "*****************************************\n\n\n";
	System.out.println(eventReport);
	
}


@Override
public void printEventResults(Client client, Florist florist)
{
	
	String eventResult = "Based on your selected parameters these results were generated: \n";
	eventResult += "Your budget was: " + NumberFormat.getCurrencyInstance().format(client.event.getBudgetAmount())
			;
	eventResult += "\nEstimated Event Cost: " + NumberFormat.getCurrencyInstance().format(client.event.getEstimatedEventCost()) + "\n";
	eventResult += "These are the florists available in your budget";

	System.out.println(eventResult);

	
	
}
@Override
public void printFloristReport(Florist florist, Client client) {
	Iterator iterator = florist.floristOptions(client.event).entrySet().iterator();
	Map.Entry me2 = null;
	while (iterator.hasNext()) {
		 me2 = (Map.Entry) iterator.next();
		florist = (Florist) me2.getKey();
	}
		String floristReport = "";
		floristReport += "\n*********************************";
		floristReport += "\nCompany name: "+ florist.getFloristName();
		floristReport += "\nContact number: "+ florist.getFloristContactNumber();
		floristReport += "\nMinimum budget required: "+ florist.getMinimumBudget();
		floristReport += "\nEstimated fee: " + florist.getTotalFee();
		floristReport +="\nTotal Event Cost: " + NumberFormat.getCurrencyInstance().format(client.event.getEstimatedEventCost().add(florist.getTotalFee()));
		System.out.println(floristReport);
}

}