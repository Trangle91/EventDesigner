import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class ClientEventTest {
	final ClientEventBuilder builder = new BuilderImpl();
	
	public Client c = new Client("Jane", "Doe", Optional.of("John"), "555-555-5555", builder);
	public LocalDate expectedEventDate = LocalDate.of(2018, 12, 25);
	public BigDecimal expectedBudgetAmount = new BigDecimal("2000.00");
	public Optional<Integer> expectedGuestCount = Optional.empty();
	public int expectedTableCount = 35;
	public Optional<String> expectedEventTheme = Optional.empty();
	public Optional<String> expectedColorPalette = Optional.empty();
	
	ClientEvent event = c.createEvent(expectedEventDate, expectedBudgetAmount, expectedGuestCount, 
									expectedTableCount, expectedEventTheme, expectedColorPalette);
	

	@Test
		public void testEventDate() {
		LocalDate actual = event.getEventDate();
		assertEquals(expectedEventDate, actual);
	}
	
	@Test
	
	public void testEventBudget() {
		BigDecimal actual = event.getBudgetAmount();
		assertEquals(expectedBudgetAmount, actual);
	}
	
	@Test 
	public void testEmptyGuestCount() {
		Optional<Integer> actual = event.getGuestCount();
		assertEquals(expectedGuestCount, actual);
	}
	
	@Test
	public void testEnteredGuestCount() {
		Optional<Integer> expectedEnteredGuestCount = Optional.of(190);
		event.setGuestCount(expectedEnteredGuestCount);
		Optional<Integer> actual = event.getGuestCount();
		assertEquals(expectedEnteredGuestCount, actual);
	}
	
	@Test 
	public void testEmptyTableCount() {
		Optional<Integer> actual = event.getGuestCount();
		assertEquals(expectedGuestCount, actual);
	}
	
	@Test 
	public void testEnteredTableCount() {
		int expectedEnteredTableCount = 19;
		event.setTableCount(expectedEnteredTableCount);
		int actual = event.getTableCount();
		assertEquals(expectedEnteredTableCount, actual);
	}
	
	@Test
	public void testEmptyEventTheme() {
		Optional<String> actual = event.getEventTheme();
		assertEquals(expectedEventTheme, actual);
	}
	
	@Test
	public void testEnteredEventTheme() {
		Optional<String> expectedEnteredEventTheme = Optional.of("wedding");
		event.setEventTheme(expectedEnteredEventTheme);
		Optional<String> actual = event.getEventTheme();
		assertEquals(expectedEnteredEventTheme, actual);
	}
	
	@Test
	public void testEmptyColorPalette() {
		Optional<String> actual = event.getColorPalette();
		assertEquals(expectedColorPalette, actual);
	}
	
	@Test
	public void testEnteredColorPalette() {
		Optional<String> expectedEnteredColorPalette = Optional.of("white and maroon");
		event.setColorPalette(expectedEnteredColorPalette);
		Optional<String> actual = event.getColorPalette();
		assertEquals(expectedEnteredColorPalette, actual);
	}
	
	@Test
	public void testDesignEvent0() { //client only wants tall pieces
		int expected = 35;
		int actual = event.designEvent(expectedTableCount, expectedBudgetAmount, TallAnchorArrangement.getTallAnchorArrangement());
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDesignEvent1() { //client wants tall pieces and 3 other arrangements
		int expected = 8;
		int actual = event.designEvent(expectedTableCount, expectedBudgetAmount, TallAnchorArrangement.getTallAnchorArrangement(), 
				VotiveArrangement.getVotiveArrangement(), SmallFloralRingArrangement.getSmallFloralRingArrangement(),
				LowFloralArrangement.getLowFloralArrangement()); 
		assertEquals(expected, actual);
	}
		

}
