import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class VotiveArrangementTest {
	VotiveArrangement votiveArrangement = VotiveArrangement.Instance;
	
@Test
public void testGetInstance() {
	assertNotNull(VotiveArrangement.getVotiveArrangement());
}
	@Test
	void testGetArrangementPrice() {
		BigDecimal actual = votiveArrangement.arrangementPrice;
		BigDecimal expected = votiveArrangement.getArrangementPrice();
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
	
	@Test
	void testArrangementReport() {
		assertNotNull(votiveArrangement.ArrangementReport());
	}

	
}
