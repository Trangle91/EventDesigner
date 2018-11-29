import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ClientTest {
	

	final ClientEventBuilder builder = new BuilderImpl();
	private Client c = new Client("Jane", "Doe", Optional.of("John"), "555-555-5555", builder);
	public String expectedClientName = "Jane Doe";
	public String expectedClientFirstName = "Jane";
	public String expectedClientLastName = "Doe";
	public String expectedClientPartnerName = "John";
	public String expectedPhoneNumber = "555-555-5555";
	
	@Test
	
	public void canGetClientName() {
		
		String actualFullName = c.getClientName();
		assertEquals(expectedClientName, actualFullName);
	}
	
	@Test
	public void canGetClientPhoneNumber() {
		
		String actualPhoneNumber = c.getPhoneNumber();
		assertEquals(expectedPhoneNumber, actualPhoneNumber);
	}
	
	@Test
	public void canGetClientPartnerName() {
		
		String actualPartnerName = c.getPartnerName();
		assertEquals(expectedClientPartnerName, actualPartnerName);
	}

	@Test
	public void noPartnerNameByDefault() {
	
		String actualPartnerName = c.getPartnerName();
		assertEquals(expectedClientPartnerName, actualPartnerName);
	}
	
	@Test
	public void canGetClientFromClientMap() {
		Client actual = c;
		String phoneNumber = "555-555-5555";
		Client expected = c.getClientAccount(phoneNumber);
		assertEquals(expected, actual);
	}

}
