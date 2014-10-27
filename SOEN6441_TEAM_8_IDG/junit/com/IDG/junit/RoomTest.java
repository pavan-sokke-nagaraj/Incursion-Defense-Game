package com.IDG.mapSimulator;

import java.awt.Graphics;
import javax.swing.DebugGraphics;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>RoomTest</code> contains tests for the class <code>{@link Room}</code>.
 *
 *
 * @author Raman
 * @version $Revision: 1.0 $
 */
public class RoomTest {
	/**
	 * Run the Room() constructor test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testRoom_1()
		throws Exception {

		Room result = new Room();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Room(int,int,char[][]) constructor test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testRoom_2()
		throws Exception {
		int x = 1;
		int y = 1;
		char[][] gameValue = new char[][] {};

		Room result = new Room(x, y, gameValue);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: argument type mismatch
		assertNotNull(result);
	}

	/**
	 * Run the void drawGameArena(Graphics,char[][]) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testDrawGameArena_1()
		throws Exception {
		Room fixture = new Room();
		fixture.blockSize = 1;
		Graphics graphic = new DebugGraphics();
		char[][] gameValue = new char[][] {};

		fixture.drawGameArena(graphic, gameValue);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: argument type mismatch
	}

	/**
	 * Run the void drawGameArena(Graphics,char[][]) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testDrawGameArena_2()
		throws Exception {
		Room fixture = new Room();
		fixture.blockSize = 1;
		Graphics graphic = new DebugGraphics();
		char[][] gameValue = new char[][] {};

		fixture.drawGameArena(graphic, gameValue);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: argument type mismatch
	}

	/**
	 * Run the void drawGameArena(Graphics,char[][]) method test.
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
		new org.junit.runner.JUnitCore().run(RoomTest.class);
	}
}