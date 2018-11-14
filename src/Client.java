
public class Client {
	String firstName;
	String lastName;
	String partnerName;
	String phoneNumber;

	public Client (String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public Client(String firstName, String lastName, String phoneNumber, String partnerName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.partnerName = partnerName;
	}

	public String getClientName() {
		return this.firstName + " " + this.lastName;

	}

	public String getPhoneNUmber() {
		return this.phoneNumber;
	}


}
