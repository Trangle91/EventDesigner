import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ClientTest {
	final ClientEventBuilder builder = new BuilderImpl();
	private Client c = new Client("FirstName", "LastName", Optional.empty(), "555-555-5555", builder);

	@Test

//change visibility for tests
	
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
	
	public void canGetClientPartnerName() {
		Optional<String> expectedPartnerName = c.partnerName; 
		String actualPartnerName = c.getPartnerName();
		assertEquals(expectedPartnerName, actualPartnerName);
	}

	public void noPartnerNameByDefault() {
		Optional<String> expectedPartnerName = c.partnerName;
		String actualPartnerName = c.getPartnerName();
		assertEquals(expectedPartnerName, actualPartnerName);
	}

}
