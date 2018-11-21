import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class ClientEventTest {
	final ClientEventBuilder builder = new BuilderImpl();
	
	Client c = new Client("Jane", "Doe", Optional.of("John"), "555-555-5555", builder);
	LocalDate expectedEventDate = LocalDate.of(2018, 12, 25);
	BigDecimal expectedBudgetAmount = new BigDecimal("2000.00");
	Optional<Integer> expectedGuestCount = Optional.empty();
	Optional<Integer> expectedTableCount = Optional.empty();
	Optional<String> expectedEventTheme = Optional.empty();
	Optional<String> expectedColorPalette = Optional.empty();
	
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
		Optional<Integer> expectedEnteredTableCount = Optional.of(19);
		event.setTableCount(expectedEnteredTableCount);
		Optional<Integer> actual = event.getTableCount();
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
	
	
	
	

}
