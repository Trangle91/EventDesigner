import java.math.BigDecimal;
//no one is able to change these in the program, visibility changed for testing

public enum VotiveArrangement {
	Instance;
	
	public String arrangementName = "votive arrangement";
	public String arrangementDescription = "a series of mixed votives in either gold or silver accentuated by lush greenery and florals";
	public  BigDecimal arrangementPrice = new BigDecimal("35.00");
	public  int numOfVotivesIncluded = 5;


	public static VotiveArrangement getVotiveArrangement() {
		return Instance;
	}

	public BigDecimal getArrangmentPrice() {
		
		return arrangementPrice;
	}

	public String getArrangementName() {
		return arrangementName;
	}


	public String getArrangementDescription() {
		return arrangementDescription;
	}

	
	public int getNumOfVotivesIncluded() {
		return numOfVotivesIncluded;
	}

}