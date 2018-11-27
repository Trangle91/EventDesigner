import java.math.BigDecimal;

public enum SmallFloralRingArrangement {
Instance;
	public String arrangementName = "small floral ring";
	public String arrangementDescription = "a small ring in a take home container filled with exquisite flowers. "
			+ "Centered in the ring is a hurricane vase with a pillar candle inside. "
			+ "The piece is accompanied by 3 votive candles.";
	public  BigDecimal arrangementPrice = new BigDecimal("55.00");
	public  int numOfVotivesIncluded = 3;
	
	public static SmallFloralRingArrangement getLowFloralArrangement() {
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
