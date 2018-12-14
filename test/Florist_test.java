import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class Florist_test {
	
	
	Florist	florist = new Florist("Flowers", "123-456-7890",new BigDecimal("50.00"), new BigDecimal("20.00"),new BigDecimal("200.00"),
			Optional.of(new BigDecimal("500.00")));

	Florist Rose = new Florist("Rose Blossom", "713-4343-4343", new BigDecimal("150"),new BigDecimal("50"),new BigDecimal("250"),
			Optional.ofNullable(new BigDecimal("500")));
	Florist Artemissa = new Florist("Artemissa", "651-091-0847", new BigDecimal("70"),new BigDecimal("20"),new BigDecimal("130"),
			Optional.ofNullable(new BigDecimal("230")));

	
	String	expectedCompanyName  = "Flowers";
	String	expectedPhoneNumber = "123-456-7890";
	BigDecimal	expectedDeliveryFee = new BigDecimal("10.00");
	BigDecimal	expectedTakeDownFee = new BigDecimal("10.00");
	BigDecimal	expectedGeneralServicesFee= new BigDecimal("10.00");
	Optional<BigDecimal> expectedMinimumBudget = Optional.empty();
	BigDecimal	expectedTotalFee = new BigDecimal("30.00");

	
final ClientEventBuilder builder = new BuilderImpl();
	
	public Client c = new Client("Jane", "Doe", Optional.of("John"), "555-555-5555", builder);
	public LocalDate expectedEventDate = LocalDate.of(2018, 12, 25);
	public BigDecimal expectedBudgetAmount = new BigDecimal("3000.00");
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
	public void testFloristMap() {
	Florist	florist = new Florist("Flowers", "123-456-7890",new BigDecimal("50.00"), new BigDecimal("20.00"),new BigDecimal("200.00"),
			Optional.of(new BigDecimal("500.00")));
	
	Florist expected = florist;
	Florist actual = florist.getParticipatingFlorists().get(expectedCompanyName);
	assertEquals(expected, actual);
	}
	
	@Test
	public void testFloristOptions() {
		florist.floristOptions(event);
		boolean actual = true;
		boolean expected = event.getPotentialFlorists().containsKey(florist);
		assertEquals(expected, actual);
	}
	
	
//	@Test
//	public void testFloristMap() {
//		HashMap<String, Florist> expectedFloristMap = new HashMap<String,Florist>();
//		expectedFloristMap.put("florist",florist);
//		expectedFloristMap.put("Rose Blossom",Rose);
//		expectedFloristMap.put("Artemissa",Artemissa);
//		
//		assertEquals(expectedFloristMap,this.floristMap);
//		
//	}
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
	
	@Test
	public void testfloristOptions() {
		
		HashMap<Florist, BigDecimal> expectedFloristList = new HashMap<Florist,BigDecimal>();
	
		
		//Rose exceeded the budget, so only florist and Artemissa were added to the list.
		expectedFloristList.put(florist, florist.getTotalFee());
		expectedFloristList.put(Artemissa, Artemissa.getTotalFee());
		
		 florist.floristOptions(event);
		
		assertEquals(expectedFloristList, event.getPotentialFlorists());
		
	} 
	
	@Test
	public void testcompareCostToBudget() {
		BigDecimal estimatedEventCost = new BigDecimal("2500.00");
		BigDecimal budgetAmount = new BigDecimal("3000.00");
		boolean expected = florist.compareCostToBudget(estimatedEventCost.add(florist.getTotalFee()), budgetAmount);
		assertTrue(expected);
		
	}
	
	@Test
	public void testFloristReport() {
		Rose.floristOptions(event);
	}

}
