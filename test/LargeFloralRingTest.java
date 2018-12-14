import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class LargeFloralRingTest {
	LargeFloralRing largeFloralRingArrangement = LargeFloralRing.Instance;
	
	
	@Test
	public void testGetInstance() {
		assertNotNull(LargeFloralRing.getLargeFloralRingArrangement());
	}
	@Test
	void testGetArrangementPrice() {
		BigDecimal actual =largeFloralRingArrangement.arrangementPrice;
		BigDecimal expected = largeFloralRingArrangement.getArrangementPrice();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetArrangementName() {
		String actual = largeFloralRingArrangement.arrangementName;
		String expected = largeFloralRingArrangement.getArrangementName();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetArrangementDescription() {
		String actual = largeFloralRingArrangement.arrangementDescription;
		String expected = largeFloralRingArrangement.getArrangementDescription();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetNumOfVotivesIncluded() {
		int actual = largeFloralRingArrangement.numOfVotivesIncluded;
		int expected = largeFloralRingArrangement.getNumOfVotivesIncluded();
		assertEquals(expected, actual);
	}
	
	@Test
	void testArrangementReport() {
		assertNotNull(largeFloralRingArrangement.ArrangementReport());
	}

}
