import java.text.NumberFormat;

public interface EventReport {
	
public String printClientReport(Client client);
void printEventReport(Client Client, ClientEvent event);
void printEventResults(Client Client, ClientEvent event);
void printFloristReport(Florist florist);
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
	eventReport += "\nTable Amount: " + event.getTableCount();
	if (event.getGuestCount() != null)
	eventReport += "\nGuest Count: " + event.getGuestCount();
	System.out.println(eventReport);
	
}


@Override
public void printEventResults(Client Client, ClientEvent event) {
	String eventResult = "Based on your selected parameters these reults were generated:";
	eventResult += "\n";
	
	
	
}
@Override
public void printFloristReport(Florist florist) {
		String floristReport = "";
		floristReport += "\n*********************************";
		floristReport += "\nCompany name: "+ florist.getFloristName();
		floristReport += "\nContact number: "+ florist.getFloristContactNumber();
		floristReport += "\nMinimum budget required: "+ florist.getMinimumBudget();
		floristReport += "\nEstimated fee: "+ florist.getTotalFee();
		System.out.println(floristReport);
}

}