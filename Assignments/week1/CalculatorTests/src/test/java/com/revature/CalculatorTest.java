package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.exceptions.Number13Exception;
import com.revature.exceptions.Number8Exception;
import com.revature.exceptions.DivideBy0Exception;
import com.revature.exceptions.MultiplyBy0Exception;
import com.revature.exceptions.SquareRootException;
import com.revature.exceptions.Number10Exception;

public class CalculatorTest {

	private static Calculator sut;
	
	/*
	 * JUnit 5
	 * 	- @BeforeAll
	 *  - @BeforeEach
	 *  - @AfterAll
	 *  - @AfterEach
	 *  
	 *  - @Test
	 *  - @Ignore
	 *  - @Order
	 */
	
	// Used to set up the test
	@BeforeAll
	public static void setUp() {
		sut = new Calculator();
	}
	
	@AfterAll
	public static void tearDown() {
		System.out.println("Tear down behavior.");
	}
	
	@BeforeEach
	public void before() {
		System.out.println("@Before each behavior");
	}
	
	@Test
	public void addOneAndTwo() {
		int expected = 3;
		int actual = sut.add(1, 2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void addEightAndFive() {
		assertThrows(Number13Exception.class, () -> sut.add(8, 5));
	}
	
	@Test
	public void addZeroAndThirteen() {
		assertThrows(Number13Exception.class, () -> sut.add(0, 13));
	}
	
	@Test
	public void subtractTenAndSix() {
		int expected = 4;
		int actual = sut.subtract(10, 6);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void subtractTwentyAndSeven() {
		assertThrows(Number13Exception.class, () -> sut.subtract(20, 7));
	}
	
	@Test
	public void subtractThirtyAndSeventeen() {
		assertThrows(Number13Exception.class, () -> sut.subtract(30, 17));
	}
	
	@Test
	public void sumOfAnArray() {
		int expected = 18;
		int actual = Calculator.add([3, 4]);
		
		assertEquals(Calculator.add([3, 4, 5, 6]), is(18));
	}
	
	@Test
	public void multiplyThreeAndFour() {
		int expected = 12;
		int actual = sut.multiply(3, 4);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void multiplyFourAndZero() {
		assertThrows(MultiplyBy0Exception.class, () -> sut.multiply(4, 0));
	}
	
	@Test
	public void multiplyTwoAndFour() {
		assertThrows(Number8Exception.class, () -> sut.multiply(2, 4));
	}
	
	@Test
	public void divideTwentyOneAndSeven() {
		int expected = 3;
		int actual = sut.divide(21, 7);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void divideSixteenAndFour() {
		assertThrows(SquareRootException.class, () -> sut.divide(16, 4));
	}
	
	@Test
	public void divideNineAndZero() {
		assertThrows(DivideBy0Exception.class, () -> sut.divide(9, 0));
	}
}