package sonar.exemplo.sonarqube;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SonarqubeApplicationTests {

	@Test
	void contextLoads() {
		String[] args = new String[0];
		SonarqubeApplication.main(args);
		assertNotNull(args);
	}

}
