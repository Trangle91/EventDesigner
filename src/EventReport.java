import java.text.NumberFormat;

public interface EventReport {
	
public String printClientReport(Client client);
void printEventReport(Client Client, ClientEvent event);

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
	clientreport += "\nClient PhoneNumber: " + client.getPhoneNumber();
	clientreport += "\nClient partner: " + client.getPartnerName();
	return clientreport;
}
@Override
public void printEventReport(Client Client, ClientEvent event) {
	System.out.println(printClientReport(Client));
	String eventReport="\n*********************************";
	eventReport += "You've entered the following parameters for your event";
	eventReport += "\nDate (YEAR-MONTH-DAY): " + event.getEventDate();
	
	eventReport += "\nExpected Budget: " + NumberFormat.getCurrencyInstance().format(event.getBudgetAmount());
	eventReport += "\nTable Amount: " + event.getTableCount();
	if (event.getGuestCount() != null)
	eventReport += "\nGuest Count: " + event.getGuestCount();
	System.out.println(eventReport);
	
}



}