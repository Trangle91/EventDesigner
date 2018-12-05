import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
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
	
	@Test
	public void canCreateClientEvent() {
		LocalDate expectedEventDate = LocalDate.of(2018, 12, 25);
		BigDecimal expectedBudgetAmount = new BigDecimal("3000.00");
		Optional<Integer> expectedGuestCount = Optional.empty();
		int expectedTableCount = 35;
		Optional<String> expectedEventTheme = Optional.empty();
		Optional<String> expectedColorPalette = Optional.empty();
		
		ClientEvent expectedEvent = c.createEvent(expectedEventDate, expectedBudgetAmount, expectedGuestCount, 
										expectedTableCount, expectedEventTheme, expectedColorPalette);
		
		assertNotNull(expectedEvent);
		
	}
	
	@Test 
	public void canGetEventFromEventMap() {
		LocalDate expectedEventDate = LocalDate.of(2018, 12, 25);
		BigDecimal expectedBudgetAmount = new BigDecimal("3000.00");
		Optional<Integer> expectedGuestCount = Optional.empty();
		int expectedTableCount = 35;
		Optional<String> expectedEventTheme = Optional.empty();
		Optional<String> expectedColorPalette = Optional.empty();
		
		ClientEvent expectedEvent = c.createEvent(expectedEventDate, expectedBudgetAmount, expectedGuestCount, 
										expectedTableCount, expectedEventTheme, expectedColorPalette);
		
		ClientEvent actualEvent = c.getClientEventFromMap(expectedEventDate);
		
		assertEquals(expectedEvent, actualEvent);
		
	}

}
