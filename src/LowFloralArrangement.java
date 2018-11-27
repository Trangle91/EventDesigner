import java.math.BigDecimal;

//visibility for testing
public enum LowFloralArrangement {
Instance;
	public String arrangementName = "low floral heavy piece";
	public String arrangementDescription = "a low centerpiece in a take home container featuring an impressive number of flowers accompanied by 3 mixed votives";
	public  BigDecimal arrangementPrice = new BigDecimal("60.00");
	public  int numOfVotivesIncluded = 3;
	
	public static LowFloralArrangement getLowFloralArrangement() {
		return Instance;
	}
	
	public String getArrangementName() {
		return arrangementName;
	}
	
	public String  getArrangementDescription() {
		return arrangementDescription;
	}
	
	public BigDecimal getArrangementPrice() {
		return arrangementPrice;
	}
	
	public int getNumOfVotivesIncluded() {
		return numOfVotivesIncluded;
	}
}
