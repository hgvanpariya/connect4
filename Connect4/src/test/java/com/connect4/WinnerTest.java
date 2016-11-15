/**
 * 
 */
package com.connect4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.connect4.util.Winner;

import junit.framework.Assert;

/**
 * @author hv185014
 *
 */
public class WinnerTest {

	int[][] arr = new int[5][5];

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() {
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 0;
		arr[0][3] = 0;
		arr[0][4] = 0;
		arr[1][0] = 1;
		arr[1][1] = 0;
		arr[1][2] = 2;
		arr[1][3] = 0;
		arr[1][4] = 0;
		arr[2][0] = 1;
		arr[2][1] = 0;
		arr[2][2] = 0;
		arr[2][3] = 2;
		arr[2][4] = 0;
		arr[3][0] = 1;
		arr[3][1] = 0;
		arr[3][2] = 0;
		arr[3][3] = 0;
		arr[3][4] = 2;
		arr[4][0] = 0;
		arr[4][1] = 0;
		arr[4][2] = 0;
		arr[4][3] = 0;
		arr[4][4] = 0;
	}

	/**
	 * Test the first player is winner or not.
	 */
	@Test
	public void testForPlayer1() {
		Winner w = new Winner();
		boolean check = w.check(arr, 1, 0, 0);
		assertTrue(check);
	}

	/**
	 * Test the second player is winner or not.
	 */
	@Test
	public void testPlayer2() {
		Winner w = new Winner();
		boolean check = w.check(arr, 2, 3, 4);
		assertTrue(check);
	}

	/**
	 * It will check if the input board is null.
	 */
	@Test
	public void checkIfBoardIsEmpty() {
		Winner w = new Winner();
		boolean check = w.check(null, 2, 3, 4);
		assertFalse(check);
	}

	/**
	 * It will check if the input board is null.
	 */
	@Test
	public void checkIfBoardIsEmptyWithBase() {
		Winner w = new Winner();
		boolean check = w.check(arr, 0, 0, 0);
		assertFalse(check);
	}

	/**
	 * It will check if the input board is null.
	 */
	@Test
	public void checkIfPlayerIsOutsideBoardRow() {
		Winner w = new Winner();
		boolean check = w.check(arr, 1, 5, 0);
		assertFalse(check);
	}

	/**
	 * It will check if the input board is null.
	 */
	@Test
	public void checkIfPlayerIsOutsideBoardCol() {
		Winner w = new Winner();
		boolean check = w.check(arr, 1, 0, 5);
		assertFalse(check);
	}

	/**
	 * It will check if the input board is null.
	 */
	@Test
	public void checkIfPlayerIsOutsideBoardColMinus() {
		Winner w = new Winner();
		boolean check = w.check(arr, 1, 0, -1);
		assertFalse(check);
	}

	/**
	 * It will check if the input board is null.
	 */
	@Test
	public void checkIfPlayerIsOutsideBoardRowMinus() {
		Winner w = new Winner();
		boolean check = w.check(arr, 1, -1, 0);
		assertFalse(check);
	}

}
