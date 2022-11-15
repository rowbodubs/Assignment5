import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class HolidayBonusStudentTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void testCalculateHolidayBonus() {
		double[][] array = new double[][] {{1,2,3},{4,5},{6,7,8}};
		double[] expected = new double[] {15.0,20.0,45.0};
		assertEquals(expected, HolidayBonus.calculateHolidayBonus(array));
	}
	@Test
	public static void testCalculateTotalHolidayBonus() {
		double[][] array = new double[][] {{1,2,3},{4,5},{6,7,8}};
		assertEquals(80, HolidayBonus.calculateHolidayBonus(array));
	}
}
