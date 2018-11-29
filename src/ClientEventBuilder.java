import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
//T.L
public interface ClientEventBuilder {
	ClientEvent buildClientEvent();
	ClientEvent getClientEvent();
	ClientEventBuilder withEventDate (final LocalDate eventDate);
	ClientEventBuilder withBudgetAmount (final BigDecimal budgetAmount);
	ClientEventBuilder withGuestCount (final Optional<Integer> guestCount);
	ClientEventBuilder withTableCount (final int tableCount);
	ClientEventBuilder withEventTheme (final Optional<String> eventTheme);
	ClientEventBuilder withColorPalette (final Optional<String> colorPalette);
}

class BuilderImpl implements ClientEventBuilder {
public ClientEvent event;

public BuilderImpl() {
	event = new ClientEvent();
}

	@Override
	public ClientEvent buildClientEvent() {
		return event;
	}


	@Override
	public ClientEventBuilder withEventDate(LocalDate eventDate) {
		event.setEventDate(eventDate);
		return this;
	}

	@Override
	public ClientEventBuilder withBudgetAmount(BigDecimal budgetAmount) {
		event.setBudgetAmount(budgetAmount);
		return this;
	}

	@Override
	public ClientEventBuilder withGuestCount(Optional<Integer> guestCount) {
		event.setGuestCount(guestCount);
		return this;
	}

	@Override
	public ClientEventBuilder withTableCount(int tableCount) {
		event.setTableCount(tableCount);
		return this;
	}

	@Override
	public ClientEventBuilder withEventTheme(Optional<String> eventTheme) {
		event.setEventTheme(eventTheme);
		return this;
	}

	@Override
	public ClientEventBuilder withColorPalette(Optional<String> colorPalette) {
		event.setColorPalette(colorPalette);
		return this;
	}
	
	public ClientEvent getClientEvent() {
		return event;
	}
}

