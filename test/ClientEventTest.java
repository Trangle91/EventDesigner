import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class ClientEventTest {
	final ClientEventBuilder builder = new BuilderImpl();
	
	public Client c = new Client("Jane", "Doe", Optional.of("John"), "555-555-5555", builder);
	public LocalDate expectedEventDate = LocalDate.of(2018, 12, 25);
	public BigDecimal expectedBudgetAmount = new BigDecimal("12000.00");
	public Optional<Integer> expectedGuestCount = Optional.empty();
	public int expectedTableCount = 35;
	public Optional<String> expectedEventTheme = Optional.empty();
	public Optional<String> expectedColorPalette = Optional.empty();
	

	Florist	florist = new Florist("Flowers", "123-456-7890",new BigDecimal("50.00"), new BigDecimal("20.00"),new BigDecimal("200.00"),
			Optional.of(new BigDecimal("500.00")));
	
	 Florist tommyRose = new Florist("Tommy Rose", "612-551-1233", new BigDecimal("100.00"), new BigDecimal("30.00"), 
			new BigDecimal("150.00"), Optional.of(new BigDecimal("300.00")));
	 Florist artemissa = new Florist("Artemissa", "651-091-0847", new BigDecimal("70.00"), 
			new BigDecimal("20.00"), new BigDecimal("130.00"), Optional.ofNullable(new BigDecimal("400.00")));
	 Florist bloomFlowers = new Florist("Bloom Flowers", "713-111-2222", new BigDecimal("100.00"), 
			new BigDecimal("40.00"), new BigDecimal("200.00"), Optional.ofNullable(new BigDecimal("350.00")));
	 Florist lakeHarrietFlowers = new Florist("Lake Harriet Flowers", "713-234-0989", new BigDecimal("120.00"), 
			new BigDecimal("50.00"), new BigDecimal("170.00"), Optional.ofNullable(new BigDecimal("350.00")));
  Florist roseBlossom = new Florist("Rose Blossom", "713-4343-4343", new BigDecimal("150.00"), 
			new BigDecimal("50.00"), new BigDecimal("250.00"), Optional.ofNullable(new BigDecimal("500.00")));
	
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
	public void testPlaceArrangements0() { //only one type of arrangement, no talls
		HashMap<Object, Integer> expected = new HashMap<Object, Integer>();
		expected.put(VotiveArrangement.getVotiveArrangement(), 35);
		
		HashMap<Object, Integer> determinedArrangements = new HashMap<Object, Integer>();
		determinedArrangements.put(VotiveArrangement.getVotiveArrangement(), 35);
		
		HashMap<Object, Integer> actual = event.placeArrangements(event.getTableCount(), 
				determinedArrangements.size(), determinedArrangements);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPlaceArrangements1() { //two types of arrangements, no talls
		HashMap<Object, Integer> expected = new HashMap<Object, Integer>();
		expected.put(VotiveArrangement.getVotiveArrangement(), 17);
		expected.put(SmallFloralRingArrangement.getSmallFloralRingArrangement(), 17);
		
		HashMap<Object, Integer> determinedArrangements = new HashMap<Object, Integer>();
		determinedArrangements.put(VotiveArrangement.getVotiveArrangement(), 0);
		determinedArrangements.put(SmallFloralRingArrangement.getSmallFloralRingArrangement(), 0);
		
		HashMap<Object, Integer> actual = event.placeArrangements(event.getTableCount(), 
				determinedArrangements.size(), determinedArrangements);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPlaceArrangements2() { //three types of arrangements, no talls
		HashMap<Object, Integer> expected = new HashMap<Object, Integer>();
		expected.put(VotiveArrangement.getVotiveArrangement(), 11);
		expected.put(SmallFloralRingArrangement.getSmallFloralRingArrangement(), 11);
		expected.put(LargeFloralRingArrangement.getLargeFloralRingArrangement(), 11);
		
		HashMap<Object, Integer> determinedArrangements = new HashMap<Object, Integer>();
		determinedArrangements.put(VotiveArrangement.getVotiveArrangement(), 0);
		determinedArrangements.put(SmallFloralRingArrangement.getSmallFloralRingArrangement(), 0);
		determinedArrangements.put(LargeFloralRingArrangement.getLargeFloralRingArrangement(), 0);
		
		HashMap<Object, Integer> actual = event.placeArrangements(event.getTableCount(), 
				determinedArrangements.size(), determinedArrangements);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPlaceArrangements3() { //four types of arrangements, no talls
		HashMap<Object, Integer> expected = new HashMap<Object, Integer>();
		expected.put(VotiveArrangement.getVotiveArrangement(), 8);
		expected.put(SmallFloralRingArrangement.getSmallFloralRingArrangement(), 8);
		expected.put(LargeFloralRingArrangement.getLargeFloralRingArrangement(), 8);
		expected.put(LowFloralArrangement.getLowFloralArrangement(), 8);
		
		HashMap<Object, Integer> determinedArrangements = new HashMap<Object, Integer>();
		determinedArrangements.put(VotiveArrangement.getVotiveArrangement(), 0);
		determinedArrangements.put(SmallFloralRingArrangement.getSmallFloralRingArrangement(), 0);
		determinedArrangements.put(LargeFloralRingArrangement.getLargeFloralRingArrangement(), 0);
		determinedArrangements.put(LowFloralArrangement.getLowFloralArrangement(), 0);
		
		HashMap<Object, Integer> actual = event.placeArrangements(event.getTableCount(), 
				determinedArrangements.size(), determinedArrangements);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPlaceArrangements4() { //all types
		HashMap<Object, Integer> expected = new HashMap<Object, Integer>();
		expected.put(VotiveArrangement.getVotiveArrangement(), 6);
		expected.put(SmallFloralRingArrangement.getSmallFloralRingArrangement(), 6);
		expected.put(LargeFloralRingArrangement.getLargeFloralRingArrangement(), 6);
		expected.put(LowFloralArrangement.getLowFloralArrangement(), 6);
		expected.put(TallAnchorArrangement.getTallAnchorArrangement(), 9);
		
		HashMap<Object, Integer> determinedArrangements = new HashMap<Object, Integer>(); //designEvent does this
		determinedArrangements.put(VotiveArrangement.getVotiveArrangement(), 0);
		determinedArrangements.put(SmallFloralRingArrangement.getSmallFloralRingArrangement(), 0);
		determinedArrangements.put(LargeFloralRingArrangement.getLargeFloralRingArrangement(), 0);
		determinedArrangements.put(LowFloralArrangement.getLowFloralArrangement(), 0);
		determinedArrangements.put(TallAnchorArrangement.getTallAnchorArrangement(), 0);
		
		HashMap<Object, Integer> actual = event.placeArrangements(event.getTableCount(), 
				determinedArrangements.size(), determinedArrangements);
		
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPlaceRemainingArrangements0() { //no tall arrangements, tests sum of arrangements in the HashMap are the same as the number of tables
		HashMap<Object, Integer> expectedArrangements = new HashMap<Object, Integer>();
		expectedArrangements.put(VotiveArrangement.getVotiveArrangement(), 12);
		expectedArrangements.put(SmallFloralRingArrangement.getSmallFloralRingArrangement(), 12);
		expectedArrangements.put(LargeFloralRingArrangement.getLargeFloralRingArrangement(), 11);
		
		int expected = 35;
		
		
		HashMap<Object, Integer> determinedArrangements = new HashMap<Object, Integer>();
		determinedArrangements.put(VotiveArrangement.getVotiveArrangement(), 0);
		determinedArrangements.put(SmallFloralRingArrangement.getSmallFloralRingArrangement(), 0);
		determinedArrangements.put(LargeFloralRingArrangement.getLargeFloralRingArrangement(), 0);
		determinedArrangements.put(LowFloralArrangement.getLowFloralArrangement(), 0);
		
		event.placeArrangements(event.getTableCount(), 4, determinedArrangements);
		
		HashMap<Object, Integer> actualArrangements = event.placeRemainingArrangements(event.getTableCount(), determinedArrangements);
		int actual = actualArrangements.values().stream().mapToInt(Integer::intValue).sum();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPlaceRemainingArrangement1() { //4 arrangements included tall ones, tests sum of arrangements in the HashMap are the same as the number of tables & the number of Tall Arrangements doesn't change
		HashMap<Object, Integer> expectedArrangements = new HashMap<Object, Integer>();
		expectedArrangements.put(VotiveArrangement.getVotiveArrangement(), 9);
		expectedArrangements.put(SmallFloralRingArrangement.getSmallFloralRingArrangement(), 9);
		expectedArrangements.put(LargeFloralRingArrangement.getLargeFloralRingArrangement(), 8);
		expectedArrangements.put(TallAnchorArrangement.getTallAnchorArrangement(), 9);
		
		int expected = 35;
		
		HashMap<Object, Integer> determinedArrangements = new HashMap<Object, Integer>();
		determinedArrangements.put(VotiveArrangement.getVotiveArrangement(), 0);
		determinedArrangements.put(SmallFloralRingArrangement.getSmallFloralRingArrangement(), 0);
		determinedArrangements.put(LargeFloralRingArrangement.getLargeFloralRingArrangement(), 0);
		determinedArrangements.put(TallAnchorArrangement.getTallAnchorArrangement(), 0);
		
		event.placeArrangements(event.getTableCount(), 4, determinedArrangements);
		
		HashMap<Object, Integer> actualArrangements = event.placeRemainingArrangements(event.getTableCount(), determinedArrangements);
		int actual = actualArrangements.values().stream().mapToInt(Integer::intValue).sum();
		
		assertEquals(expected, actual); //test sums
		assertEquals(expectedArrangements.get(TallAnchorArrangement.getTallAnchorArrangement()), actualArrangements.get(TallAnchorArrangement.getTallAnchorArrangement()));
	}
	
@Test
public void testDesignEvent() {
	
	HashMap<Object, Integer> actual = event.designEvent(VotiveArrangement.getVotiveArrangement(), SmallFloralRingArrangement.getSmallFloralRingArrangement(), 
						LargeFloralRingArrangement.getLargeFloralRingArrangement(), 
						TallAnchorArrangement.getTallAnchorArrangement());
	
	assertTrue(actual.containsKey(VotiveArrangement.getVotiveArrangement()));
	assertTrue(actual.containsKey(SmallFloralRingArrangement.getSmallFloralRingArrangement()));
	assertTrue(actual.containsKey(LargeFloralRingArrangement.getLargeFloralRingArrangement()));
	assertTrue(actual.containsKey(TallAnchorArrangement.getTallAnchorArrangement()));

}

@Test
public void testCalculateEstimatedCostArrangements() {
	BigDecimal expected = new BigDecimal("2580.00");
	
	HashMap<Object, Integer> determinedArrangements = new HashMap<Object, Integer>();
	determinedArrangements.put(VotiveArrangement.getVotiveArrangement(), 9);
	determinedArrangements.put(SmallFloralRingArrangement.getSmallFloralRingArrangement(), 9);
	determinedArrangements.put(LargeFloralRingArrangement.getLargeFloralRingArrangement(), 8);
	determinedArrangements.put(TallAnchorArrangement.getTallAnchorArrangement(), 9);
	
	event.calculateEstimatedCostArrangements(determinedArrangements);
	
	BigDecimal actual =event.getEstimatedEventCost();
		
	assertEquals(expected, actual);
}

@Test
public void testFindFlorists() {
	event.findFlorists(florist);
	assertTrue(event.getFloristsWithInBudget().containsKey(tommyRose));
	assertTrue(event.getFloristsWithInBudget().containsKey(artemissa));
	assertTrue(event.getFloristsWithInBudget().containsKey(roseBlossom));
	assertTrue(event.getFloristsWithInBudget().containsKey(lakeHarrietFlowers));
	assertTrue(event.getFloristsWithInBudget().containsKey(bloomFlowers));
}

@Test
public void testFindFlorists1() {
	event.findFlorists(florist);	
}

//@Test
//public void testCalculateCostIndividualArrangement() {
//	
//	HashMap<Object, Integer> determinedArrangements = new HashMap<Object, Integer>();
//	determinedArrangements.put(VotiveArrangement.getVotiveArrangement(), 9);
//	
//}
	
}
