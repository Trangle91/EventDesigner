import java.math.BigDecimal;

class TallAnchorArrangement extends Arrangement {
	private static String arrangementName = "Tall anchor piece";
	private static String arrangementDescription = "a tall clear glass pilsner base topped with a removable plastic dish filled with "
			+ "flowers of a various heights. Serves as an excellent eye catching piece that will transform any venue when "
			+ "placed strategically around a room.";
	private static BigDecimal arrangementPrice = new BigDecimal("130.00");
	private static int numOfVotivesIncluded = 3;
	private static int heightInInches = 32;
	
	TallAnchorArrangement(String arrangementName, String arrangementDescription, BigDecimal arrangementPrice, int numOfVotivesIncluded, int heightInInches) {
		super(arrangementName, arrangementDescription, arrangementPrice, numOfVotivesIncluded);
		this.heightInInches = heightInInches;
	}
	
	@Override
	BigDecimal getArrangmentPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String getArrangementName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String getArrangementDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	int getNumOfVotivesIncluded() {
		// TODO Auto-generated method stub
		return 0;
	}

}
