package com.IDG.mapSimulator;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.DebugGraphics;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ArsenalTest</code> contains tests for the class <code>{@link Arsenal}</code>.
 *
 *
 * @author Raman
 * @version $Revision: 1.0 $
 */
public class ArsenalTest {
	/**
	 * Run the Arsenal() constructor test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testArsenal_1()
		throws Exception {

		Arsenal result = new Arsenal();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Arsenal() constructor test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testArsenal_2()
		throws Exception {

		Arsenal result = new Arsenal();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Arsenal() constructor test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testArsenal_3()
		throws Exception {

		Arsenal result = new Arsenal();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Arsenal() constructor test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	

	/**
	 * Run the void draw(Graphics) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testDraw_1()
		throws Exception {
		Arsenal fixture = new Arsenal();
		fixture.box2Ypos = 1;
		fixture.health = new Rectangle();
		fixture.money = new Rectangle();
		fixture.upgradeButton = new Rectangle();
		fixture.towers = new Rectangle[] {};
		fixture.box2Xpos = 1;
		fixture.sellButton = new Rectangle();
		Graphics graphic = new DebugGraphics();

		fixture.draw(graphic);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at javax.swing.DebugGraphics.setColor(Unknown Source)
		//       at com.IDG.mapSimulator.Arsenal.draw(Arsenal.java:157)
	}

	/**
	 * Run the void draw(Graphics) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testDraw_2()
		throws Exception {
		Arsenal fixture = new Arsenal();
		fixture.box2Ypos = 1;
		fixture.health = new Rectangle();
		fixture.money = new Rectangle();
		fixture.upgradeButton = new Rectangle();
		fixture.towers = new Rectangle[] {};
		fixture.box2Xpos = 1;
		fixture.sellButton = new Rectangle();
		Graphics graphic = new DebugGraphics();

		fixture.draw(graphic);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at javax.swing.DebugGraphics.setColor(Unknown Source)
		//       at com.IDG.mapSimulator.Arsenal.draw(Arsenal.java:157)
	}

	/**
	 * Run the void draw(Graphics) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	

	/**
	 * Run the void towerClick(int) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testTowerClick_1()
		throws Exception {
		Arsenal fixture = new Arsenal();
		fixture.box2Ypos = 1;
		fixture.health = new Rectangle();
		fixture.money = new Rectangle();
		fixture.upgradeButton = new Rectangle();
		fixture.towers = new Rectangle[] {};
		fixture.box2Xpos = 1;
		fixture.sellButton = new Rectangle();
		int mouseClick = 1;

		fixture.towerClick(mouseClick);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 0
		//       at com.IDG.mapSimulator.Arsenal.towerClick(Arsenal.java:338)
	}

	/**
	 * Run the void towerClick(int) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testTowerClick_2()
		throws Exception {
		Arsenal fixture = new Arsenal();
		fixture.box2Ypos = 1;
		fixture.health = new Rectangle();
		fixture.money = new Rectangle();
		fixture.upgradeButton = new Rectangle();
		fixture.towers = new Rectangle[] {};
		fixture.box2Xpos = 1;
		fixture.sellButton = new Rectangle();
		int mouseClick = 1;

		fixture.towerClick(mouseClick);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 0
		//       at com.IDG.mapSimulator.Arsenal.towerClick(Arsenal.java:338)
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
		new org.junit.runner.JUnitCore().run(ArsenalTest.class);
	}
}