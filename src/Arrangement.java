import java.math.BigDecimal;

public abstract class Arrangement {
private BigDecimal arrangementPrice;
private String arrangementName;
private String arrangementDescription;
private int numOfVotivesIncluded;


abstract BigDecimal getArrangmentPrice();
abstract String getArrangementName();
abstract String getArrangementDescription();
abstract int getNumOfVotivesIncluded();

	
}
