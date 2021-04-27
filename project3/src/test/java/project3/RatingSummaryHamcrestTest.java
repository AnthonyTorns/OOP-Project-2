package project3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

class RatingSummaryHamcrestTest {

    public RatingSummary rs;
	
	@BeforeEach
	public void setup() {
		rs = new RatingSummary("A1EE2E3N7PW666", 2);
	}

	// From class RatingSummary
	@Test
	void testCreateList() {
		List<Float> list =  rs.createList();
		
		assertThat(ArrayList.class, equalTo(list.getClass()));
	}

	@AfterEach
	public void cleanup() {
		rs = null;
	}
	

} 