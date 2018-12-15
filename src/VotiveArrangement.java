import java.math.BigDecimal;

//no one is able to change these in the program, visibility changed for testing
import java.text.NumberFormat;

public enum VotiveArrangement {
	Instance;
	public int arrangementNum = 5;
	public String arrangementName = "votive arrangement";
	public String arrangementDescription = "a series of mixed votives in either gold or silver accentuated by lush greenery and florals";
	public  BigDecimal arrangementPrice = new BigDecimal("35.00");
	public  int numOfVotivesIncluded = 5;

 
	public static VotiveArrangement getVotiveArrangement() {
		return Instance;
	}

	public BigDecimal getArrangementPrice() {
		
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

	public String ArrangementReport(){
		String report;
		report = "Arrangement #:" + arrangementNum;
		report += "\nArrangement Name: " + arrangementName;
		report += "\nDescription: " + arrangementDescription;
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		report += "\nPrice: " + fmt.format(arrangementPrice);
		return report += "\n# of Votives Included: " + numOfVotivesIncluded + "\n*****************************";
				
	
	}
	
	@Override
	public String toString() {
		return String.format(arrangementName);
	}
}

