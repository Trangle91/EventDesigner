import java.math.BigDecimal;

public enum LargeFloralRingArrangement {
Instance;
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
}
