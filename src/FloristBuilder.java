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
	
	public Builder(String companyName, String phoneNumber,Optional<BigDecimal> minimumBudget){
		florist = new Florist(companyName,phoneNumber,minimumBudget);
		
	}

	@Override
	public Florist buildFlorist() {
		return florist;
	}

	@Override
	public Florist getFlorist() {
		return florist;
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