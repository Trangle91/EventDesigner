import java.math.BigDecimal;
//visibility changed for testing

public enum TallAnchorArrangement  {
	Instance;
	
	public String arrangementName = "Tall anchor piece";
	public String arrangementDescription = "a tall clear glass pilsner base topped with a removable plastic dish filled with "
			+ "flowers of a various heights. Serves as an excellent eye catching piece that will transform any venue when "
			+ "placed strategically around a room.";
	public BigDecimal arrangementPrice = new BigDecimal("130.00");
	public int numOfVotivesIncluded = 3;
	public int heightInInches = 32;
	
	
	public static TallAnchorArrangement getTallAnchorArrangement() {
		return Instance;
	}
	
	public BigDecimal getArrangmentPrice() {
		// TODO Auto-generated method stub
		return arrangementPrice;
	}

	
	public String getArrangementName() {
		// TODO Auto-generated method stub
		return arrangementName;
	}

	
	public String getArrangementDescription() {
		// TODO Auto-generated method stub
		return arrangementDescription;
	}

	
	public int getNumOfVotivesIncluded() {
		// TODO Auto-generated method stub
		return numOfVotivesIncluded;
	}
	
	public int getHeightInInches() {
		return heightInInches;
	}

}
