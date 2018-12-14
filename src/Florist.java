import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Florist { //still needs a method that returns florist(s) after input of budget from arrangement


	private Client client;
	private ClientEvent event;
	private String companyName;
	private String phoneNumber;
	private BigDecimal deliveryFee;
	private BigDecimal takeDownFee;
	private BigDecimal generalServiceFee;
	private Optional<BigDecimal> minimumBudget;
	
	 static Florist tommyRose = new Florist("Tommy Rose", "612-551-1233", new BigDecimal("100.00"), new BigDecimal("30.00"), 
			new BigDecimal("150.00"), Optional.of(new BigDecimal("300.00")));
	static Florist artemissa = new Florist("Artemissa", "651-091-0847", new BigDecimal("70.00"), 
			new BigDecimal("20.00"), new BigDecimal("130.00"), Optional.ofNullable(new BigDecimal("400.00")));
	static Florist bloomFlowers = new Florist("Bloom Flowers", "713-111-2222", new BigDecimal("100.00"), 
			new BigDecimal("40.00"), new BigDecimal("200.00"), Optional.ofNullable(new BigDecimal("350.00")));
	static Florist lakeHarrietFlowers = new Florist("Lake Harriet Flowers", "713-234-0989", new BigDecimal("120.00"), 
			new BigDecimal("50.00"), new BigDecimal("170.00"), Optional.ofNullable(new BigDecimal("350.00")));
	static  Florist roseBlossom = new Florist("Rose Blossom", "713-4343-4343", new BigDecimal("150.00"), 
			new BigDecimal("50.00"), new BigDecimal("250.00"), Optional.ofNullable(new BigDecimal("500.00")));
	
	public static Map<String, Florist> floristMap = Stream.of(
			new AbstractMap.SimpleEntry<String, Florist>("Tommy Rose", tommyRose),
			new AbstractMap.SimpleEntry<String, Florist>("Artemissa", artemissa),
			
			new AbstractMap.SimpleEntry<String, Florist>("Bloom Flowers", bloomFlowers),
			
			new AbstractMap.SimpleEntry<String, Florist>("Lake Harriet Flowers", lakeHarrietFlowers),
			
			new AbstractMap.SimpleEntry<String, Florist>("Rose Blossom", roseBlossom)		
			
		).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
			
	
	
	public Florist() {
		
	}
	

	
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
	
	public Map<String, Florist> getPotentialFloristMap() {
		return floristMap;
	}
	
//	public void  floristOptions(ClientEvent event){
//		
//		floristMap.forEach((key, value) -> {
//			
//		BigDecimal estimatedEventCost = (value.getTotalFee().add(event.getEstimatedEventCost()));
//		if (estimatedEventCost.compareTo(event.getBudgetAmount()) <= 0) {
//		potentialFloristMap.put(value, estimatedEventCost);
//		
//		}
//		});
//		
//		
//		}
//	
//	//changed to protected for testing
//	protected boolean compareCostToBudget(BigDecimal estimatedCost, BigDecimal budget) {
//		int i = estimatedCost.compareTo(budget);
//		return i == -1;
//	}
	

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
