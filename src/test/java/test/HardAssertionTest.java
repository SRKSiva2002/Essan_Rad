package test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import com.Essan_Rad.GenericUtils.BaseClass;


public class HardAssertionTest extends BaseClass {

	@Test
	public void hardAssert1() {
		System.out.println("---Hard Assert 1---");
		System.out.println("---Hard Assert 2---");
		System.out.println("---Hard Assert 3---");
		assertEquals("S", "I");
		System.out.println("---Hard Assert 4---");
		System.out.println("---Hard Assert 5---");
	}
	
	@Test
	public void hardAssert2() {
		System.out.println("---Hard Assert 6---");
		fail();
		System.out.println("---Hard Assert 7---");
	}
	
	@Test
	public void hardAssert3() {
		System.out.println("---Hard Assert 8---");
		assertFalse(true);
		System.out.println("---Hard Assert 9---");
	}
	
	@Test
	public void hardAssert4() {
		System.out.println("---Hard Assert 10---");
		assertSame(eLib, eLib);
		System.out.println("---Hard Assert11---");
	}
	
	@Test
	public void hardAssert5() {
		System.out.println("---Hard Assert 12---");
		fail("Hard assert failings");
		System.out.println("---Hard Assert 13---");
	}
	
	@Test
	public void hardAssert6() {
		System.out.println("---Hard Assert 14---");
		assertNotNull(driver);
		System.out.println("---Hard Assert 15---");
	}
}
