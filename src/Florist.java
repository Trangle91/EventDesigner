import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Optional;

public class Florist {

	private Client client;
	private ClientEvent event;
	private String companyName;
	private String phoneNumber;
	private BigDecimal deliveryFee;
	private BigDecimal takeDownFee;
	private BigDecimal generalServiceFee;
	private Optional<BigDecimal> minimumBudget;
	private HashMap<String, Florist> floristMap;
	
	public Florist(String companyName, String phoneNumber,Optional<BigDecimal> minimumBudget) {
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		minimumBudget = Optional.empty();
	}
	
	public Florist(String companyName, String phoneNumber, BigDecimal deliveryFee, BigDecimal takeDownFee,
			BigDecimal generalServiceFee, Optional<BigDecimal> minimumBudget) {
		
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.deliveryFee = deliveryFee;
		this.takeDownFee = takeDownFee;
		this.generalServiceFee = generalServiceFee;
		minimumBudget = Optional.empty();
		floristMap = new HashMap<String, Florist>();
	}

	public ClientEvent getEvent() {
		return event;
	}

	public BigDecimal getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(BigDecimal deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public BigDecimal getTakeDownFee() {
		return takeDownFee;
	}

	public void setTakeDownFee(BigDecimal takeDownFee) {
		this.takeDownFee = takeDownFee;
	}

	public BigDecimal getGeneralServiceFee() {
		return generalServiceFee;
	}

	public void setGeneralServiceFee(BigDecimal generalServiceFee) {
		this.generalServiceFee = generalServiceFee;
	}

	public Optional<BigDecimal> getMinimumBudget() {
		return minimumBudget;
	}

	public void setMinimumBudget(Optional<BigDecimal> minimumBudget) {
		this.minimumBudget = minimumBudget;
	}

	public String getFloristName() {
		return this.companyName;
	}

	public String getFloristContactNumber() {
		return phoneNumber;
	}

	public BigDecimal getTotalFee() {
		return this.generalServiceFee.add(this.deliveryFee).add(this.takeDownFee);
		
	}
	
}
