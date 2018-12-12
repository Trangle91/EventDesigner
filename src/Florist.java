import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import java.util.Objects;
import java.util.Optional;


public class Florist { //still needs a method that returns florist(s) after input of budget from arrangement


	private Client client;
	private ClientEvent event;
	private String companyName;
	private String phoneNumber;
	private BigDecimal deliveryFee;
	private BigDecimal takeDownFee;
	private BigDecimal generalServiceFee;
	private Optional<BigDecimal> minimumBudget;
	private HashMap<String, Florist> floristMap = new HashMap<String, Florist>();;

	
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
		floristMap.put(companyName, this);
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
	
	public HashMap<Florist, BigDecimal> floristOptions(){
		HashMap<Florist, BigDecimal> floristList = new HashMap<Florist,BigDecimal>();
	
		Iterator<Map.Entry<String, Florist>> it = floristMap.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, Florist> florist = it.next();
			Florist potentialFlorist = florist.getValue();
			BigDecimal associatedFee = floristList.get(potentialFlorist);
			associatedFee = event.getEstimatedEventCost().add(potentialFlorist.getTotalFee());
			int i = associatedFee.compareTo(event.getBudgetAmount());
			if( i == (-1))
				floristList.put(potentialFlorist, associatedFee);
		}
		return floristList;		
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if(!(o instanceof Florist))
			return false;
		Florist florist = (Florist) o;
		return companyName == florist.companyName && Objects.equals(phoneNumber, florist.phoneNumber) &&
				Objects.equals(minimumBudget, florist.minimumBudget);
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(companyName, phoneNumber, minimumBudget);
	}
	
}
