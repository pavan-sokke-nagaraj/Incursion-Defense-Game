package com.IDG.mapSimulator;

import java.awt.Graphics;
import javax.swing.DebugGraphics;
import org.junit.*;
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
		char towerId = '';
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
	@Test
	public void testClearInformation_1()
		throws Exception {
		Tower fixture = new Tower('T', 1, 1, 1, 1, "", 1, 1);
		fixture.box2Ypos = 1;
		fixture.box2Xpos = 1;
		Graphics graphic = new DebugGraphics();

		fixture.clearInformation(graphic);

		
	}

	/**
	 * Run the void drawMarketInformation(Graphics) method test.
	 *
	 * @throws Exception
	 *
	*
	 */
	@Test
	public void testDrawMarketInformation_1()
		throws Exception {
		Tower fixture = new Tower('G', 1, 1, 1, 1, "", 1, 1);
		fixture.box2Ypos = 1;
		fixture.box2Xpos = 1;
		Graphics graphic = new DebugGraphics();

		fixture.drawMarketInformation(graphic);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at javax.swing.DebugGraphics.clearRect(Unknown Source)
		//       at com.IDG.mapSimulator.Tower.drawTowerInformation(Tower.java:116)
		//       at com.IDG.mapSimulator.Tower.drawMarketInformation(Tower.java:148)
	}



	/**
	 * Run the void drawTowerInformation(Graphics) method test.
	 *
	 * @throws Exception
	 *
	*
	 */
	@Test
	public void testDrawTowerInformation_1()
		throws Exception {
		Tower fixture = new Tower('D', 1, 1, 1, 1, "", 1, 1);
		fixture.box2Ypos = 1;
		fixture.box2Xpos = 1;
		Graphics graphic = new DebugGraphics();

		fixture.drawTowerInformation(graphic);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at javax.swing.DebugGraphics.clearRect(Unknown Source)
		//       at com.IDG.mapSimulator.Tower.drawTowerInformation(Tower.java:116)
	}

	
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