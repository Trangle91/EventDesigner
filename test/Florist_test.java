import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class Florist_test {
	
	Florist	florist = new Florist("Flowers", "123-456-7890",new BigDecimal("50.00"),
			new BigDecimal("20.00"),new BigDecimal("200.00"),
			Optional.of(new BigDecimal("500.00")));
		
	String	expectedCompanyName = "Flowers";
	String	expectedPhoneNumber = "123-456-7890";
	BigDecimal	expectedDeliveryFee = new BigDecimal("50.00");
	BigDecimal	expectedTakeDownFee = new BigDecimal("20.00");
	BigDecimal	expectedGeneralServicesFee = new BigDecimal("200.00");
	Optional<BigDecimal> expectedMinimumBudget = Optional.empty();
	BigDecimal	expectedTotalFee = new BigDecimal("270.00");
	
	
	@Test
	public void testGetFloristCompanyName() {
		String actual = florist.getFloristName();
		assertEquals(expectedCompanyName,actual);
	}
	
	@Test
	public void testGetFloristContactNumber() {
		assertEquals(expectedPhoneNumber,florist.getFloristContactNumber());
	}
	
	@Test
	public void testGetDeliveryFee() {
		assertEquals(expectedDeliveryFee, florist.getDeliveryFee());
	}
	
	@Test
	public void testGetTakeDownFee() {
		assertEquals(expectedTakeDownFee, florist.getTakeDownFee());
	}
	
	@Test
	public void testGetGeneralServicesFee() {
		assertEquals(expectedGeneralServicesFee, florist.getGeneralServiceFee());
	}
	
	@Test
	public void testGetTotalFee() {
		
		assertEquals(expectedTotalFee, florist.getTotalFee());
	}
	
	@Test
	public void testGetMinimumBudget() {
		expectedMinimumBudget = Optional.of(new BigDecimal("500.00"));
		florist.setMinimumBudget(expectedMinimumBudget);
		assertEquals(expectedMinimumBudget,florist.getMinimumBudget());
	}

}
