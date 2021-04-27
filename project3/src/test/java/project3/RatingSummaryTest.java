package project3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class RatingSummaryTest {

	public RatingSummary rs;
	
	@BeforeEach
	public void setup() {
		rs = new RatingSummary("A1EE2E3N7PW666", 2);
	}

	@Test
	void testSortStatsNotSame() {
		float actualOutput = 3;
		rs.setList(3, 2);
		
		Assertions.assertEquals(rs.sortStats(), actualOutput);
	}

	@AfterEach
	public void cleanup() {
		rs = null;
	}

}
