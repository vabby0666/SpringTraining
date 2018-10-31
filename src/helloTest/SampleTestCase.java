package helloTest;


import static org.junit.Assert.*;

import org.junit.Test;

public class SampleTestCase {
	Arithmetic am=new Arithmetic();
	@Test
	public void testAddPositive() {
		assertEquals(8,am.add(5, 3));
	}
	@Test
	public void testAddNegative() {
		assertNotEquals(20,am.add(10,20));
	}
}
