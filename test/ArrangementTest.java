import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class ArrangementTest {
	private static String arrangementName = "Tall anchor piece";
	private static String arrangementDescription = "a tall clear glass pilsner base topped with a removable plastic dish filled with "
			+ "flowers of a various heights. Serves as an excellent eye catching piece that will transform any venue when "
			+ "placed strategically around a room.";
	private static BigDecimal arrangementPrice = new BigDecimal("130.00");
	private static int numOfVotivesIncluded = 3;
	private static int heightInInches = 32;
	
	@Test
	void testCreateTallAnchorArrangement() {
		TallAnchorArrangement arrangement = new TallAnchorArrangement(arrangementName, arrangementDescription, arrangementPrice, numOfVotivesIncluded, heightInInches);
	}

}
