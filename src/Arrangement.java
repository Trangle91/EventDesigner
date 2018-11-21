import java.math.BigDecimal;


public abstract class Arrangement {
private String arrangementName;
private String arrangementDescription;
private BigDecimal arrangementPrice;
private int numOfVotivesIncluded;

Arrangement(String arrangementName, String arrangementDescription, BigDecimal arrangementPrice, int numOfVotivesIncluded) {

}

abstract BigDecimal getArrangmentPrice();
abstract String getArrangementName();
abstract String getArrangementDescription();
abstract int getNumOfVotivesIncluded();

	
}
