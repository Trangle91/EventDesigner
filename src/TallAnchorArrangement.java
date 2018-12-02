import java.math.BigDecimal;
//<<<<<<< HEAD
import java.util.HashMap;
//=======
import java.text.NumberFormat;
//>>>>>>> branch 'master' of https://github.com/russndi/EventDesigner.git

//visibility changed for testing

public enum TallAnchorArrangement  {
	Instance;

	public String arrangementName = "Tall anchor piece";
	public String arrangementDescription = "a tall clear glass pilsner base topped with a removable plastic dish filled with "
			+ "flowers of a various heights. Serves as an excellent eye catching piece that will transform any venue when "
			+ "placed strategically around a room.";
	public BigDecimal arrangementPrice = new BigDecimal("130.00");
	public int numOfVotivesIncluded = 3;
	public int heightInInches = 32;



	public static TallAnchorArrangement getTallAnchorArrangement() {
		return Instance;
	}

	public BigDecimal getArrangmentPrice() {
		// TODO Auto-generated method stub
		return arrangementPrice;
	}
 

	public String getArrangementName() {
		// TODO Auto-generated method stub
		return arrangementName;
	}


	public String getArrangementDescription() {
		// TODO Auto-generated method stub
		return arrangementDescription;
	}


	public int getNumOfVotivesIncluded() {
		// TODO Auto-generated method stub
		return numOfVotivesIncluded;
	}
	public String ArrangementReport(){
		String report;
		report = "\nArrangement Name: " + arrangementName;
		report += "\nDescription: " + arrangementDescription;
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		report += "\nPrice: " + fmt.format(arrangementPrice);
		return report += "\n# of Votives Included: " + numOfVotivesIncluded + "\n*****************************\n";
				
	
	}
	public int getHeightInInches() {
		return heightInInches;
	}

	public int determineNumTallArrangements(int tableCount, int totalNumArrangements) { 
		if (totalNumArrangements == 1) {
			//return message suggesting pairing tall pieces with another type of arrangement
			return 0;
		}

		else {
			if (tableCount < 5) {
				//return message saying tall anchor pieces are recommended for a minimum table count of 5
				return 0;
			}

			if (tableCount >= 5 && tableCount <= 10) {
				return 2;
			}

			else {
				return tableCount / 5 + 2;

			}
		}

	}
}

