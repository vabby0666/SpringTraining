package helloTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAssertions {
	String obj1="medplus";
	String obj2="medplus";
	String obj3="kf";
	String obj4="kf";
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
	public void testSame() {
		assertSame("they are not same",obj3,obj4);
	}
	@Test
	public void testNotSame() {
		assertNotSame("they are same",obj2,obj4);
	}
	@Test
	public void testNull() {
		assertNull(obj5);
	}
	@Test
	public void testNotNull() {
		assertNotNull(obj4);
	}
	@Test
	public void testTrue() {
		assertTrue(var1<var2);
	}
	@Test
	public void testFalse() {
		assertFalse(var1>var2);
	}
	@Test
	public void testArray() {
		assertArrayEquals(arm1, arm2);
	}
}
