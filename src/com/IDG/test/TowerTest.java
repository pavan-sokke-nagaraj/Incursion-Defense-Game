package com.IDG.test;

import java.awt.Graphics;

import javax.swing.DebugGraphics;

import org.junit.*;

import com.IDG.mapSimulator.Tower;

import static org.junit.Assert.*;

/**
 * The class <code>TowerTest</code> contains tests for the class <code>{@link Tower}</code>.
 *
*
 * @author Raman
 * @version Revision: 1.0
 */
public class TowerTest {
	/**
	 * Run the Tower() constructor test.
	 *
	 * @throws Exception
	 *
	*
	 */
	@Test
	public void testTower_1()
		throws Exception {

		Tower result = new Tower();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Tower(char,int,int,int,int,String,int,int) constructor test.
	 *
	 * @throws Exception
	 *
	*
	 */
	@Test
	public void testTower_2()
		throws Exception {
		char towerId = 'G';
		int costToBuy = 1;
		int level = 1;
		int range = 1;
		int power = 1;
		String attackType = "";
		int costToSell = 1;
		int costToUpgrade = 1;

		Tower result = new Tower(towerId, costToBuy, level, range, power, attackType, costToSell, costToUpgrade);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void clearInformation(Graphics) method test.
	 *
	 * @throws Exception
	 *
	*
	 */

	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	*
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	*
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TowerTest.class);
	}
}