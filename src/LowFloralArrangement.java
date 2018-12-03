import java.math.BigDecimal;
import java.text.NumberFormat;

//visibility for testing
public enum LowFloralArrangement {
Instance;
	public int arrangementNum = 2;
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
	public String ArrangementReport(){
		String report;
		report = "Arrangement #:" + arrangementNum;
		report += "\nArrangement Name: " + arrangementName;
		report += "\nDescription: " + arrangementDescription;
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		report += "\nPrice: " + fmt.format(arrangementPrice);
		return report += "\n# of Votives Included: " + numOfVotivesIncluded + "\n*****************************\n";
				
	
	}
}
