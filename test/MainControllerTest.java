import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainControllerTest {

	@Test
	void welcomeMessageTest() {
		MainController controller = new MainController();
		controller.welcomeMessage();
		assertNotNull(welcomeMessage);
	}

}
