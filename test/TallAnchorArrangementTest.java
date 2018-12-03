import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class ArrangementTest {
	
	TallAnchorArrangement tallAnchorArrangement = TallAnchorArrangement.Instance;
	
	
//	@Test
//	void testGetInstanceTallAnchorArrangement() {
//		TallAnchorArrangement actual = TallAnchorArrangement.Instance;
//		TallAnchorArrangement expected = TallAnchorArrangement.getTallAnchorArrangement();
//		assertEquals(expected, actual);
//	}
	
	@Test
	void testGetTallAnchorArrangementPrice() {
		BigDecimal expected = tallAnchorArrangement.arrangementPrice;
		BigDecimal actual = tallAnchorArrangement.getArrangementPrice();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetTallAnchorArrangementName() {
		String expected = tallAnchorArrangement.arrangementName;
		String actual = tallAnchorArrangement.getArrangementName();
		assertEquals(expected, actual);
	}
	
	@Test 
	void testGetTallAnchorArrangementDescription() {
		String expected = tallAnchorArrangement.arrangementDescription;
		String actual = tallAnchorArrangement.getArrangementDescription();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetTallAnchorArrangementVotivesIncluded() {
		int expected = tallAnchorArrangement.numOfVotivesIncluded;
		int actual = tallAnchorArrangement.getNumOfVotivesIncluded();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetHeightInInches() {
		int expected = tallAnchorArrangement.heightInInches;
		int actual = tallAnchorArrangement.getHeightInInches();
		assertEquals(expected, actual);
	}
	
	@Test
	void testDetermineNumberOfArrangements0() {
		int tableCount = 7;
		int expected = 2;
		int actual = tallAnchorArrangement.determineNumTallArrangements(tableCount, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	void testDetermineNumberOfArrangements1() {
		int tableCount = 35;
		int expected = 9;
		int actual = tallAnchorArrangement.determineNumTallArrangements(tableCount, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	void testDetermineNumberOfArrangements2() {
		int tableCount = 46;
		int expected = 11;
		int actual = tallAnchorArrangement.determineNumTallArrangements(tableCount, 2);
		assertEquals(expected, actual);
	}
	
}
