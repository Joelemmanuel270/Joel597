package ddt;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	
	int i=10;
	int a=10;
	
	@Test
	public void m1() {
		
		
		
		Assert.assertEquals(i,a);
		
		
	}
	
	@Test
	public void m2() {
		
		
		
		Assert.assertTrue(i==a);
		
	}
	
	@Test
	public void m3() {
		String s= "priya";
		Assert.assertNotEquals(s.contains("iya"), "not true");

	}
}
