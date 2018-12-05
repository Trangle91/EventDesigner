import java.time.LocalDate;
import java.util.Objects;

public class ClientEventMapKey {
	private Client client;
	private LocalDate eventDate;


	public ClientEventMapKey(Client client, LocalDate eventDate) {
		this.client = client;
		this.eventDate = eventDate;
	}

	@Override

	public int hashCode() {
		return Objects.hash(client, eventDate);

	}

	@Override

	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof ClientEventMapKey)) {
			return false;
		}

		ClientEventMapKey clientEventKey = (ClientEventMapKey) o;
		return eventDate == clientEventKey.eventDate &&
				Objects.equals(client, clientEventKey.client);
	}

}
