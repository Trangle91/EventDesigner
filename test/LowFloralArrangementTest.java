import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class LowFloralArrangementTest {
	LowFloralArrangement lowFloralArrangement = LowFloralArrangement.Instance;
	
//	@Test
//	void testGetInstanceVotiveArrangement() {
//		VotiveArrangement actual = VotiveArrangement.Instance;
//		VotiveArrangement expected = VotiveArrangement.getVotiveArrangement();
//		assertEquals(expected, actual);
//	}
	
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

}
