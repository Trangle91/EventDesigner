import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;
//T.L
public class ClientEvent {
	

private LocalDate eventDate; //required
private BigDecimal budgetAmount; //required
private int tableCount = 0;

private Optional<Integer> guestCount = Optional.empty(); 
private Optional<String> eventTheme = Optional.empty(); //optional eventually will dropped in favor of implementing inherited types of events
private Optional<String> colorPalette = Optional.empty(); //optional

private int numTallAnchorArrangements = 0;
private int numLowFloralArrangements = 0;
private int numLargeFloralRingArrangements = 0;
private int numSmallFloralRingArrangements = 0;
private int numVotiveArrangements = 0;

private HashMap<Client, ClientEvent> clientEventMap = new HashMap<Client, ClientEvent>();

public ClientEvent() {
	
}
	


public LocalDate getEventDate() {
	return eventDate;
}

public void setEventDate(LocalDate eventDate) {
	this.eventDate = eventDate;
}

public BigDecimal getBudgetAmount() {
	return budgetAmount;
}

public void setBudgetAmount(BigDecimal budgetAmount) {
	this.budgetAmount = budgetAmount;
}

public Optional<Integer> getGuestCount() {
	return this.guestCount;
}

public void setGuestCount(Optional<Integer> guestCount) {
	this.guestCount = guestCount;
}

public int getTableCount() {
	return this.tableCount;
}

public void setTableCount(int tableCount) {
	this.tableCount = tableCount;
}

public Optional<String> getEventTheme() {
	return this.eventTheme;
}

public void setEventTheme(Optional<String> eventTheme) {
	this.eventTheme = eventTheme;
}

public Optional<String> getColorPalette() {
	return this.colorPalette;
}

public void setColorPalette(Optional<String> colorPalette) {
	this.colorPalette = colorPalette;
}


public int designEvent(int tableCount, BigDecimal budgetAmount, Object...arrangements) { //can throw an exception 
	boolean containsTallAnchorArrangement = Arrays.stream(arrangements).anyMatch(TallAnchorArrangement.getTallAnchorArrangement()::equals);
	int totalNumArrangements = arrangements.length;
	int numOfArrangements;
	
	if (arrangements.length == 0) {
		return 0; //eventually throw a message asking client to select an arrangement type. 
	}
	
	if (containsTallAnchorArrangement == true && arrangements.length == 1) { //client only wants tall pieces
		return tableCount;
	}
	
	if (containsTallAnchorArrangement == true) {
		totalNumArrangements = totalNumArrangements - 1;
		numTallAnchorArrangements = TallAnchorArrangement.getTallAnchorArrangement().determineNumberOfArrangements(tableCount);
		tableCount = tableCount - numTallAnchorArrangements;
		return numOfArrangements = tableCount / totalNumArrangements;
		
	}
	
	else {
		return numOfArrangements = tableCount / totalNumArrangements;
	}
}
}


