import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class Florist_test {
	
	Florist	florist = new Florist("Flowers", "123-456-7890",new BigDecimal("50.00"), new BigDecimal("20.00"),new BigDecimal("200.00"),
			Optional.of(new BigDecimal("500.00")));
	
	String	expectedCompanyName  = "Flowers";
	String	expectedPhoneNumber = "123-456-7890";
	BigDecimal	expectedDeliveryFee = new BigDecimal("50.00");
	BigDecimal	expectedTakeDownFee = new BigDecimal("20.00");
	BigDecimal	expectedGeneralServicesFee= new BigDecimal("200.00");
	Optional<BigDecimal> expectedMinimumBudget = Optional.empty();
	BigDecimal	expectedTotalFee = new BigDecimal("270.00");
	
	final ClientEventBuilder builder = new BuilderImpl();
	
	public Client c = new Client("Jane", "Doe", Optional.of("John"), "555-555-5555", builder);
	public LocalDate expectedEventDate = LocalDate.of(2018, 12, 25);
	public BigDecimal expectedBudgetAmount = new BigDecimal("5000.00");
	public Optional<Integer> expectedGuestCount = Optional.empty();
	public int expectedTableCount = 35;
	public Optional<String> expectedEventTheme = Optional.empty();
	public Optional<String> expectedColorPalette = Optional.empty();
	
	ClientEvent event = c.createEvent(expectedEventDate, expectedBudgetAmount, expectedGuestCount, 
									expectedTableCount, expectedEventTheme, expectedColorPalette);
	

	
	@Test
	public void testCreateFloristWithAllFields() {
		Florist	florist = new Florist("Flowers", "123-456-7890",new BigDecimal("50.00"), new BigDecimal("20.00"),new BigDecimal("200.00"),
				Optional.of(new BigDecimal("500.00")));
		assertNotNull(florist);
		
	}
	
	@Test
	public void testCreateFloristWith3Fields() {
		Florist	florist = new Florist("Flowers", "123-456-7890", Optional.of(new BigDecimal("500.00")));
		assertNotNull(florist);
	}
	

	
	@Test
	public void testFloristMap1() {
	assertTrue(florist.getPotentialFloristMap().containsKey("Artemissa"));
	assertTrue(florist.getPotentialFloristMap().containsKey("Rose Blossom"));
	
	}
	
	@Test
	public void testGetFloristCompanyName() {
		String actual = florist.getFloristName();
		assertEquals(expectedCompanyName,actual);
	}
	
	@Test
	public void testGetFloristContactNumber() {
		assertEquals(expectedPhoneNumber,florist.getFloristContactNumber());
	}
	
	@Test
	public void testGetDeliveryFee() {
		assertEquals(expectedDeliveryFee, florist.getDeliveryFee());
	}
	
	@Test
	public void testSetDeliveryFee() {
		florist.setDeliveryFee(new BigDecimal("100.00"));
		assertEquals(new BigDecimal("100.00"),florist.getDeliveryFee());
	}
	
	@Test
	public void testGetTakeDownFee() {
		assertEquals(expectedTakeDownFee, florist.getTakeDownFee());
	}
	
	@Test
	public void testSetTakeDownFee() {
		florist.setTakeDownFee(new BigDecimal("50.00"));
		assertEquals(new BigDecimal("50.00"),florist.getTakeDownFee());
	}
	
	@Test
	public void testGetGeneralServicesFee() {
		assertEquals(expectedGeneralServicesFee, florist.getGeneralServiceFee());
	}
	
	@Test
	public void testSetGeneralFee() {
		florist.setGeneralServiceFee(new BigDecimal("200.00"));
		assertEquals(new BigDecimal("200.00"),florist.getGeneralServiceFee());
	}
	
	@Test
	public void testGetTotalFee() {
		
		assertEquals(expectedTotalFee, florist.getTotalFee());
	}
	
	@Test
	public void testGetMinimumBudget() {
		expectedMinimumBudget = Optional.of(new BigDecimal("500.00"));
		florist.setMinimumBudget(expectedMinimumBudget);
		assertEquals(expectedMinimumBudget,florist.getMinimumBudget());
	}
	

}
