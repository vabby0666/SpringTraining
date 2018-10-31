package helloTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class JunitAssertions {
	String obj1="medplus";
	String obj2="medplus";
	
	String obj5=null;
	int var1=15;
	int var2=25;
	int[] arm1= {10,20,30};
	int[] arm2= {10,20,30};
	@Test
	public void testEquals() {
		assertEquals("they are not equal",obj1,obj2);
	}
	@Test
	public void testNull() {
		assertNull(obj5);
	}
	@Test
	public void testAdd() {
		assertTrue(var1<var2);
	}
	@Test
	public void testArray() {
		assertArrayEquals(arm1, arm2);
	}
}
