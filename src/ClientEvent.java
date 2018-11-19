import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public class ClientEvent {
	//T.L

private LocalDate eventDate; //required
private BigDecimal budgetAmount; //required

private Optional<Integer> guestCount = Optional.empty();
private Optional<Integer> tableCount = Optional.empty();  
private Optional<String> eventTheme = Optional.empty(); //optional eventually will dropped in favor of implementing inherited types of events
private Optional<String> colorPalette = Optional.empty(); //optional

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

public Optional<Integer> getTableCount() {
	return this.tableCount;
}

public void setTableCount(Optional<Integer> tableCount) {
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


	
}


