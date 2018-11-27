import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class VotiveArrangementTest {
	VotiveArrangement votiveArrangement = VotiveArrangement.Instance;
	
//	@Test
//	void testGetInstanceVotiveArrangement() {
//		VotiveArrangement actual = VotiveArrangement.Instance;
//		VotiveArrangement expected = VotiveArrangement.getVotiveArrangement();
//		assertEquals(expected, actual);
//	}
	
	@Test
	void testGetArrangementPrice() {
		BigDecimal actual = votiveArrangement.arrangementPrice;
		BigDecimal expected = votiveArrangement.getArrangmentPrice();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetArrangementName() {
		String actual = votiveArrangement.arrangementName;
		String expected = votiveArrangement.getArrangementName();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetArrangementDescription() {
		String actual = votiveArrangement.arrangementDescription;
		String expected = votiveArrangement.getArrangementDescription();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetNumOfVotivesIncluded() {
		int actual = votiveArrangement.numOfVotivesIncluded;
		int expected = votiveArrangement.getNumOfVotivesIncluded();
		assertEquals(expected, actual);
	}
	
}
