import java.math.BigDecimal;
import java.text.NumberFormat;

public enum LargeFloralRingArrangement {
Instance;
	public int arrangementNum = 1; //added to help user select from console ui
	public String arrangementName = "large floral ring";
	public String arrangementDescription = "a large ring in a take home container filled with sumptuous flowers. "
			+ "Centered in the ring is a cyclinder vase with a large pillar candle inside. "
			+ "The piece is accompanied by 3 votive candles.";
	public  BigDecimal arrangementPrice = new BigDecimal("75.00");
	public  int numOfVotivesIncluded = 3;
	
	public static LargeFloralRingArrangement getLargeFloralRingArrangement() {
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
		return report += "\n# of Votives Included: " + numOfVotivesIncluded + "\n*****************************";
				
	
	}
}
