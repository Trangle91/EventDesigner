import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

//client directs the building of the event

public class Client {

	private String firstName;
	private String lastName;
	private Optional<String> partnerName = Optional.empty(); //replace with builder if more optional fields added
	private String phoneNumber;
	public ClientEvent event;

	public ClientEventBuilder builder;

	public Client(String firstName, String lastName, Optional<String> partnerName, String phoneNumber, ClientEventBuilder builder) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.partnerName = partnerName;
		this.builder = builder;
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

	public String getPhoneNUmber() {
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

	public ClientEvent createEvent(LocalDate eventDate, BigDecimal budgetAmount, Optional<Integer> guestCount, 
			Optional<Integer> tableCount, Optional<String> eventTheme, Optional<String> colorPalette) {

		event = builder.withEventDate(eventDate)
				.withBudgetAmount(budgetAmount)
				.withGuestCount(guestCount)
				.withTableCount(tableCount)
				.withEventTheme(eventTheme)
				.withColorPalette(colorPalette)
				.buildClientEvent();
		
		return event;
	}
}

