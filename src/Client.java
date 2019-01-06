import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

//client directs the building of the event

public class Client {

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private Optional<String> partnerName = Optional.empty(); //replace with builder if more optional fields added
	private String phoneNumber;
	private ClientEvent event;
	private LocalDateTime lastLogOnDateTime = null;
	private LocalDateTime lastLogOffDateTime = null;
	private ClientEventMapKey clientEventMapKey;

	private ClientEventBuilder builder;

	private static  HashMap<String, Client> clientMap = new HashMap<String, Client>();
	private HashMap<ClientEventMapKey, ClientEvent> clientEventMap = new HashMap<ClientEventMapKey, ClientEvent>();
	

	static Properties defaultProperties = new Properties();

	static {

		try {
			InputStream input = new FileInputStream(Client.class.getName().toLowerCase() + "-default.properties");
			defaultProperties.load(input);
		} catch (IOException e) {
			defaultProperties.setProperty("client.count", "0");
		}

	}


	public Client(String firstName, String lastName, Optional<String> partnerName, String phoneNumber, ClientEventBuilder builder) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber =phoneNumber;
		this.partnerName = partnerName;
		this.phoneNumber = phoneNumber;
		this.builder = builder;
		clientMap.put(phoneNumber, this);
	}
	
	
	public static void initializer() throws IOException {

		Properties properties = new Properties(defaultProperties);

		try {
			InputStream input = new FileInputStream(Client.class.getName().toLowerCase() + ".properties");
			properties.load(input);
		}
		catch (FileNotFoundException e) {
		}
		catch (IOException e) {
			throw e;
		}

		int count = Integer.parseInt(properties.getProperty("client.count", "1").trim());
		for (int index = 0; index < count; index++) {
			String prefix = "client." + index + ".";
			String username = properties.getProperty(prefix + "username").trim();
			String password = properties.getProperty(prefix + "password").trim();
			String lastLogOnTime = properties.getProperty(prefix + "lastLogOnTime".trim());
			String lastLogOffTime = properties.getProperty(prefix + "lastLogOffTime".trim());
			if (username != null && password != null) {
				addClient(username, password);
				//new client form should show up or print a message to make a new client
			}
		}
	}

	private static void addClient(String username, String password) {
		
		
	}

	public String getClientName() {
		return this.firstName + " " + this.lastName;

	}


	void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	private void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPartnerName() {
		return this.partnerName.orElse(" ");
	}

	void setPartnerName(Optional<String> partnerName) {
		this.partnerName = partnerName;
	}

	public ClientEvent getClientEvent() {
		return this.builder.getClientEvent();
	} 

	public Client getClientAccount(String phoneNumber) {
		return clientMap.get(phoneNumber);
	}
	
	public LocalDateTime getLastLogOffDateTime() {
		return lastLogOffDateTime;
	}


	public void setLastLogOffDateTime(LocalDateTime lastLogOffDateTime) {
		this.lastLogOffDateTime = lastLogOffDateTime;
	}


	public ClientEvent createEvent(LocalDate eventDate, BigDecimal budgetAmount, Optional<Integer> guestCount, 
			int tableCount, Optional<String> eventTheme, Optional<String> colorPalette) {

		event = builder.withEventDate(eventDate)
				.withBudgetAmount(budgetAmount)
				.withGuestCount(guestCount)
				.withTableCount(tableCount)
				.withEventTheme(eventTheme)
				.withColorPalette(colorPalette)
				.buildClientEvent();

		ClientEventMapKey clientEventMapKey = new ClientEventMapKey(this, eventDate);

		clientEventMap.put(clientEventMapKey, event);

		return event;
	}


	public ClientEvent getClientEventFromMap(LocalDate eventDate) { //used after saving an event to the map, can return null if not in map
		ClientEventMapKey  key = new ClientEventMapKey(this, eventDate);
		return clientEventMap.get(key);
	}
	
	public static Client login(String username, String password) {
		Client client = clientMap.get(username);
		if(client == null || !client.password.equals(password))
			return null;
		client.lastLogOnDateTime = LocalDateTime.now();
		return client;
	}
	
	public void logout() {
		setLastLogOffDateTime(LocalDateTime.now());
		
	}
	
	

	@Override

	public int hashCode() {
		return Objects.hash(firstName, lastName, phoneNumber);

	}

	@Override

	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Client)) {
			return false;
		}

		Client client = (Client) o;
		return firstName == client.firstName &&
				Objects.equals(lastName, client.lastName) &&
				Objects.equals(phoneNumber, client.phoneNumber);
	}

}

