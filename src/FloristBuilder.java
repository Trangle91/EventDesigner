import java.math.BigDecimal;
import java.util.Optional;

public interface FloristBuilder {
	
	Florist buildFlorist();
	Florist getFlorist();
	FloristBuilder withDeliveryFee(final BigDecimal deliveryFee);
	FloristBuilder withTakeDownFee(final BigDecimal takeDownFee);
	FloristBuilder withGeneralServiceFee(final BigDecimal generalServiceFee);
	FloristBuilder withMinimumBudget(final Optional<BigDecimal> minimumBudget);
}

class Builder implements FloristBuilder{
	public Florist florist;
	public Florist florist5;

	public Builder(String companyName, String phoneNumber,Optional<BigDecimal> minimumBudget){
		florist = new Florist(companyName,phoneNumber,minimumBudget);
	}

	public Builder(String companyName, String phoneNumber, BigDecimal deliveryFee, BigDecimal takeDownFee,
			BigDecimal generalServiceFee, Optional<BigDecimal> minimumBudget){
		florist = new Florist(companyName,phoneNumber,deliveryFee,takeDownFee,generalServiceFee,minimumBudget);

	}
	
	public Builder(){
		Florist florist1 = new Florist("Tommy Rose", "612-551-1233", new BigDecimal("100"),new BigDecimal("30"),new BigDecimal("150"),
				Optional.ofNullable(new BigDecimal("300")));
		Florist florist2 = new Florist("Artemissa", "651-091-0847", new BigDecimal("70"),new BigDecimal("20"),new BigDecimal("130"),
				Optional.ofNullable(new BigDecimal("230")));
		Florist florist3 = new Florist("Lake Harriet Flowers", "713-234-0989", new BigDecimal("120"),new BigDecimal("50"),new BigDecimal("70"),
				Optional.ofNullable(new BigDecimal("350")));
		Florist florist4 = new Florist(" Bloom Flowers", "713-111-2222", new BigDecimal("100"),new BigDecimal("40"),new BigDecimal("200"),
				Optional.ofNullable(new BigDecimal("400")));
		 florist5 = new Florist("Rose Blossom", "713-433-4343", new BigDecimal("150"),new BigDecimal("50"),new BigDecimal("250"),
				Optional.ofNullable(new BigDecimal("500")));
		
	}

	
	@Override
	public Florist buildFlorist() {
		return florist;
	}

	@Override
	public Florist getFlorist() {
		return florist5;
	}

	@Override
	public FloristBuilder withDeliveryFee(BigDecimal deliveryFee) {
		florist.setDeliveryFee(deliveryFee);
		return this;
	}

	@Override
	public FloristBuilder withTakeDownFee(BigDecimal takeDownFee) {
		florist.setTakeDownFee(takeDownFee);
		return this;
	}

	@Override
	public FloristBuilder withGeneralServiceFee(BigDecimal generalServiceFee) {
		florist.setGeneralServiceFee(generalServiceFee);
		return this;
	}

	@Override
	public FloristBuilder withMinimumBudget(Optional<BigDecimal> minimumBudget) {
		florist.setMinimumBudget(minimumBudget);
		return this;
	}
	
}