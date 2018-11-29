import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

//client directs the building of the event

public class Client {

	public String firstName;
	public String lastName;
	public Optional<String> partnerName = Optional.empty(); //replace with builder if more optional fields added
	public String phoneNumber;
	public ClientEvent event;

	public ClientEventBuilder builder;
	
	private HashMap<String, Client> clientMap = new HashMap<String, Client>();
	
	

	public Client(String firstName, String lastName, Optional<String> partnerName, String phoneNumber, ClientEventBuilder builder) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.partnerName = partnerName;
		this.phoneNumber = phoneNumber;
		this.builder = builder;
		clientMap.put(phoneNumber, this);
	}

	public String getClientName() {
		return this.firstName + " " + this.lastName;

	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPartnerName() {
		return this.partnerName.orElse(" ");
	}

	public void setPartnerName(Optional<String> partnerName) {
		this.partnerName = partnerName;
	}

	public ClientEvent getClientEvent() {
		return this.builder.getClientEvent();
	}
	
	public Client getClientAccount(String phoneNumber) {
		return clientMap.get(phoneNumber);
	}

	public ClientEvent createEvent(LocalDate eventDate, BigDecimal budgetAmount, Optional<Integer> guestCount, 
			int tableCount, Optional<String> eventTheme, Optional<String> colorPalette) {

		event = builder.withEventDate(eventDate)
				.withBudgetAmount(budgetAmount)
				.withGuestCount(guestCount)
				.withTableCount(tableCount)
				.withEventTheme(eventTheme)
				.withColorPalette(colorPalette)
				.buildClientEvent();
		
		return event;
	}
	
	@Override
	
	public int hashCode() {
		return Objects.hash(firstName, lastName, phoneNumber);
		
	}
	
	@Override
	
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Client)) {
			return false;
		}
		
		Client client = (Client) o;
		return firstName == client.firstName &&
				Objects.equals(lastName, client.lastName) &&
				Objects.equals(phoneNumber, client.phoneNumber);
	}

}

