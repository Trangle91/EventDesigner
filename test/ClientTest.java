import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;


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
	public void canCreateClient() {
		Client client = new Client("Test", "Doe", Optional.of("Eric"), "555-555-4555", builder);
		assertNotNull(client);
	}
	
	
	@Test
	
	public void canGetClientName() {
		
		assertEquals(expectedClientName, c.getClientName());
	}
	
	@Test
	public void canGetClientPhoneNumber() {
		
		assertEquals(expectedPhoneNumber, c.getPhoneNumber());
	} 
	
	@Test
	public void canGetClientPartnerName() {
		
		assertEquals(expectedClientPartnerName, c.getPartnerName());
	}

	@Test
	public void noPartnerNameByDefault() {
	
		assertEquals(expectedClientPartnerName, c.getPartnerName());
	}
	
	@Test
	public void setClientName() {
		c.setFirstName("Janey");
		c.setLastName("Doey");
		assertEquals("Janey Doey", c.getClientName());
	}
	
	@Test
	public void setClientPartnerName() {
		c.setPartnerName(Optional.of("Johnny"));
		assertEquals("Johnny", c.getPartnerName());
	}
	
	@Test
	public void canGetClientEvent() {
		LocalDate expectedEventDate = LocalDate.of(2018, 12, 25);
		BigDecimal expectedBudgetAmount = new BigDecimal("3000.00");
		Optional<Integer> expectedGuestCount = Optional.empty();
		int expectedTableCount = 35;
		Optional<String> expectedEventTheme = Optional.empty();
		Optional<String> expectedColorPalette = Optional.empty();
		
		ClientEvent expectedEvent = c.createEvent(expectedEventDate, expectedBudgetAmount, expectedGuestCount, 
										expectedTableCount, expectedEventTheme, expectedColorPalette);
		assertEquals(expectedEvent, c.getClientEvent());
		
	}
	
	@Test
	public void canGetClientFromClientMap() {
		String phoneNumber = "555-555-5555";
		assertEquals(c, c.getClientAccount(phoneNumber));
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
