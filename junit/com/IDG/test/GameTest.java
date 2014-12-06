/**
 * 
 */
package com.IDG.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.IDG.controller.Game;


/**
 * The class <code>GameTest</code> contains tests for the class
 * <code>{@link Game}</code>.
 * @author wangguan
 *
 */
public class GameTest {

	private Game game = null, game2 = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		game = Game.getInstance();
		game2 = Game.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test the Singleton Pattern, check if there is only 1 instance.
	 * Test method for {@link com.IDG.controller.Game#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		assertEquals(true, game == game2);
	}

}
