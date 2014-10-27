package com.IDG.test;

import org.junit.*;

import com.IDG.controller.GameController;

import static org.junit.Assert.*;

/**
 * The class <code>GameControllerTest</code> contains tests for the class <code>{@link GameController}</code>.
 *
 */
public class GameControllerTest {
	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	*
	 */
	@Test
	public void testMain_1()
		throws Exception {
		String[] args = new String[] {};

		GameController.main(args);

		// add additional test code here
	}

	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 10:36 AM
	 */
	@Test
	public void testMain_2()
		throws Exception {
		String[] args = new String[] {};

		GameController.main(args);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
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
		new org.junit.runner.JUnitCore().run(GameControllerTest.class);
	}
}