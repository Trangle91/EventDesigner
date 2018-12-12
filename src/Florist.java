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
	public LinkedList<Florist> floristOptions(HashMap<String, Florist> florists){
		LinkedList<Florist> floristList = new LinkedList<Florist>();
		BigDecimal estimatedCost = new BigDecimal("0.0");
		Iterator<Map.Entry<String, Florist>> it = florists.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, Florist> florist = it.next();
			Florist potentialFlorist = florist.getValue();
			estimatedCost = event.getEstimatedEventCost().add(potentialFlorist.getTotalFee());
			int i = estimatedCost.compareTo(event.getBudgetAmount());
			if( i == (-1))
				floristList.add(potentialFlorist);
		}
		return floristList;		
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
	public String toString()
	{
		String floristReport = "";
		floristReport += "\n*********************************";
		floristReport += "\nCompany name: "+ companyName;
		floristReport += "\nContact number: "+ phoneNumber;
		floristReport += "\nMinimum budget required: "+ minimumBudget;
		floristReport += "\nEstimated fee: "+ deliveryFee + takeDownFee + generalServiceFee;
		return floristReport;
	}
	
	
	public LinkedList<Florist> floristOptions(){
		LinkedList<Florist> floristList = new LinkedList<Florist>();
		BigDecimal estimatedCost = new BigDecimal("0.0");
		Iterator<Map.Entry<String, Florist>> it = floristMap.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, Florist> florist = it.next();
			Florist potentialFlorist = florist.getValue();
			estimatedCost = event.getEstimatedEventCost().add(potentialFlorist.getTotalFee());
			int i = estimatedCost.compareTo(event.getBudgetAmount());
			if( i == (-1))
				floristList.add(potentialFlorist);
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
