import java.math.BigDecimal;
import java.text.NumberFormat;

public enum SmallFloralRing {
Instance;
	public int arrangementNum = 3;
	public String arrangementName = "small floral ring";
	public String arrangementDescription = "a small ring in a take home container filled with exquisite flowers. "
			+ "Centered in the ring is a hurricane vase with a pillar candle inside. "
			+ "The piece is accompanied by 3 votive candles.";
	public  BigDecimal arrangementPrice = new BigDecimal("55.00");
	public  int numOfVotivesIncluded = 3;
	
	public static SmallFloralRing getSmallFloralRingArrangement() {
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
		return report += "\n# of Votives Included: " + numOfVotivesIncluded;
	
	}
}
