import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class LowFloralArrangementTest {
	LowFloral lowFloralArrangement = LowFloral.Instance;

	@Test
	public void getInstance() {
		assertNotNull(LowFloral.getLowFloralArrangement());
	}
	
	@Test
	void testGetArrangementPrice() {
		BigDecimal actual =lowFloralArrangement.arrangementPrice;
		BigDecimal expected = lowFloralArrangement.getArrangementPrice();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetArrangementName() {
		String actual = lowFloralArrangement.arrangementName;
		String expected = lowFloralArrangement.getArrangementName();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetArrangementDescription() {
		String actual = lowFloralArrangement.arrangementDescription;
		String expected = lowFloralArrangement.getArrangementDescription();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetNumOfVotivesIncluded() {
		int actual = lowFloralArrangement.numOfVotivesIncluded;
		int expected = lowFloralArrangement.getNumOfVotivesIncluded();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testArrangementReport() {
		assertNotNull(lowFloralArrangement.ArrangementReport());
	}

}
