import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class SmallFloralRingTest {
	SmallFloralRing smallFloralRingArrangement = SmallFloralRing.Instance;
	
@Test
public void testGetInstance() {
	assertNotNull(SmallFloralRing.getSmallFloralRingArrangement());
}
	
	@Test
	void testGetArrangementPrice() {
		BigDecimal actual = smallFloralRingArrangement.arrangementPrice;
		BigDecimal expected = smallFloralRingArrangement.getArrangementPrice();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetArrangementName() {
		String actual = smallFloralRingArrangement.arrangementName;
		String expected = smallFloralRingArrangement.getArrangementName();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetArrangementDescription() {
		String actual = smallFloralRingArrangement.arrangementDescription;
		String expected = smallFloralRingArrangement.getArrangementDescription();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetNumOfVotivesIncluded() {
		int actual = smallFloralRingArrangement.numOfVotivesIncluded;
		int expected = smallFloralRingArrangement.getNumOfVotivesIncluded();
		assertEquals(expected, actual);
	}
	@Test
	void testArrangementReport() {
		assertNotNull(smallFloralRingArrangement.ArrangementReport());
	}


}
