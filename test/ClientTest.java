import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ClientTest {
	private Client c = new Client("FirstName", "LastName", "555-555-5555", "PartnerName");

	@Test


	public void canGetClientName() {
		String expectedFullName = c.firstName + " " + c.lastName;
		String actualFullName = c.getClientName();
		assertEquals(expectedFullName, actualFullName);
	}

	public void canGetClientPhoneNumber() {
		String expectedPhoneNumber = c.phoneNumber;
		String actualPhoneNumber = c.getPhoneNUmber();
		assertEquals(expectedPhoneNumber, actualPhoneNumber);
	}

	

}
